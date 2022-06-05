<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Buyer Orders</title>
<style>
input[type=text] {
	width: 130px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	background-color: white;
	background-position: 10px 10px;
	background-repeat: no-repeat;
	margin-top: 2px;
	margin-left: 25%;
	padding-top: 2px;
	padding-right: 25%;
	padding-bottom: 5px;
	padding-left: 10px;
	-webkit-transition: width 0.4s ease-in-out;
	transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
	width: 50%;
}

#search {
	margin-left: 25%;
}

.pagination li:hover {
	cursor: pointer;
}

body {
	background-color: #eee;
}

table th, table td {
	text-align: center;
}
</style>
<link rel="stylesheet" href="/css/styles.css">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default bg-success navbar-dark">
		<div class="container-fluid">

			<div class="navbar-header navbar-right">
				<a href="/recycleManagementHomePage">
					<button onclick="myFunction()" class="btn btn-info btn-lg">
						<span class="glyphicon glyphicon-log-out"></span> Log out
					</button>
				</a>
			</div>

			<div class="navbar-header">
				<button class="btn btn-info btn-lg" id="goback"
					onclick="history.go(-1);">
					<span class="glyphicon glyphicon-arrow-left"></span> Go Back
				</button>
			</div>

			<div class="navbar-custom" style="text-align: center;">
				<span class="navbar-style">Recycle Management System</span>
			</div>

		</div>
	</nav>
	<div class="container content">
		<div style="background: rgb(139, 0, 139);" class="jumbotron heading">
			<h1 style="color: white; text-align: center">Past Orders</h1>
		</div>
		<div class="form-group">
			<select class="form-control" name="state" id="maxRows">
				<option value="5000">Show ALL Rows</option>
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="70">70</option>
				<option value="100">100</option>
			</select>

		</div>
		<table id="buyerTable"
			class="table table-striped table-bordered table-sm" cellspacing="0"
			width="100%">
			<tr>
				<th>Request Id</th>
				<th>Amount</th>
				<th>Quantity Ordered</th>
				<th>Location</th>
				<th>Order Date</th>
				<th>Paid Amount</th>
				<th>Order Status</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${records}" var="order" varStatus="status">
				<tr>
					<td>${order.requestId}</td>
					<td>Rs. ${order.amount}</td>
					<td>${order.quantity}</td>
					<td>${order.location}</td>
					<td>${order.requestDate}</td>
					<td>Rs. ${order.paidAmount}</td>
					<td>${statusList[status.index]}</td>
					<td><c:if test="${payList[status.index]}">
							<a
								href="/payForOrder?requestId=${order.requestId}&amount=${order.amount}&paidamount=${order.paidAmount}">Pay</a>
						</c:if> <c:if test="${!payList[status.index]}">-</c:if></td>
				</tr>
			</c:forEach>

		</table>
		<div class='pagination-container'>
			<nav>
				<ul class="pagination">

					<li data-page="prev"><span> &lt; <span class="sr-only">(current)</span></span>
					</li>
					<!--	Here the JS Function Will Add the Rows -->
					<li data-page="next" id="prev"><span> &gt; <span
							class="sr-only">(current)</span></span></li>
				</ul>
			</nav>
		</div>

		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script>
    getPagination('#buyerTable');

    

    function getPagination(table) {
        var lastPage = 1;

        $('#maxRows').on('change', function (evt) {
            lastPage = 1;
            $('.pagination')
                .find('li')
                .slice(1, -1)
                .remove();
            var trnum = 0; // reset tr counter
            var maxRows = parseInt($(this).val()); // get Max Rows from select option

            if (maxRows == 5000) {
                $('.pagination').hide();
            } else {
                $('.pagination').show();
            }

            var totalRows = $(table + ' tbody tr').length; // numbers of rows
            $(table + ' tr:gt(0)').each(function () {
// each TR in  table and not the header
                trnum++; // Start Counter
                if (trnum > maxRows) {
// if tr number gt maxRows

                    $(this).hide(); // fade it out
                }
                if (trnum <= maxRows) {
                    $(this).show();
                } // else fade in Important in case if it ..
            }); //  was fade out to fade it in

// if tr total rows gt max rows option
            var pagenum = Math.ceil(totalRows / maxRows); // ceil total(rows/maxrows) to get ..
//	numbers of pages
            for (var i = 1; i <= pagenum;) {
// for each page append pagination li
                $('.pagination #prev')
                    .before(
                        '<li data-page="' +
                        i +
                        '">\
                                          <span>' +
                        i++ +
                        '<span class="sr-only">(current)</span></span>\
                                        </li>'
                    )
                    .show();
            } // end for i

            $('.pagination [data-page="1"]').addClass('active'); // add active class to the first li
            $('.pagination li').on('click', function (evt) {
// on click each page
                evt.stopImmediatePropagation();
                evt.preventDefault();
                var pageNum = $(this).attr('data-page'); // get it's number

                var maxRows = parseInt($('#maxRows').val()); // get Max Rows from select option

                if (pageNum == 'prev') {
                    if (lastPage == 1) {
                        return;
                    }
                    pageNum = --lastPage;
                }
                if (pageNum == 'next') {
                    if (lastPage >= $('.pagination li').length - 2) {
                        return;
                    }
                    pageNum = ++lastPage;
                }

                lastPage = pageNum;
                var trIndex = 0; // reset tr counter
                $('.pagination li').removeClass('active'); // remove active class from all li
                $('.pagination [data-page="' + lastPage + '"]').addClass('active'); // add active class to the clicked
// $(this).addClass('active');					// add active class to the clicked
                limitPagging();
                $(table + ' tr:gt(0)').each(function () {
// each tr in table not the header
                    trIndex++; // tr index counter
// if tr index gt maxRows*pageNum or lt maxRows*pageNum-maxRows fade if out
                    if (
                        trIndex > maxRows * pageNum ||
                        trIndex <= maxRows * pageNum - maxRows
                    ) {
                        $(this).hide();
                    } else {
                        $(this).show();
                    } //else fade in
                }); // end of for each tr in table
            }); // end of on click pagination list
            limitPagging();
        })
            .val(5)
            .change();

// end of on select change

// END OF PAGINATION
    }

    function limitPagging() {
        // alert($('.pagination li').length)

        if ($('.pagination li').length > 7) {
            if ($('.pagination li.active').attr('data-page') <= 3) {
                $('.pagination li:gt(5)').hide();
                $('.pagination li:lt(5)').show();
                $('.pagination [data-page="next"]').show();
            }
            if ($('.pagination li.active').attr('data-page') > 3) {
                $('.pagination li:gt(0)').hide();
                $('.pagination [data-page="next"]').show();
                for (let i = (parseInt($('.pagination li.active').attr('data-page')) - 2); i <= (parseInt($('.pagination li.active').attr('data-page')) + 2); i++) {
                    $('.pagination [data-page="' + i + '"]').show();

                }

            }
        }
    }

    $(function () {
        // Just to append id number for each row
        $('table tr:eq(0)').prepend('<th> S.No </th>');

        var id = 0;

        $('table tr:gt(0)').each(function () {
            id++;
            $(this).prepend('<td>' + id + '</td>');
        });
    });
</script>
		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>