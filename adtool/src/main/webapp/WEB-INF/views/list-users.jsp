<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AD Tool</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<div class="container">
	<div class="col-md-offset-1 col-md-10">
		</br>
		<div style="text-align: right" class=logo>
			<img
				src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAWUAAACNCAMAAABYO5vSAAAAt1BMVEUAZjH///8AXyKhuakAZC4AYSgAXBwAYysAYCYAYSUAWhgAXR8AYScAWhcAWBL1+vju9vIAVgsAbzrf7OXr7+whcEHZ5t+GrJXP39ZVh2bn8eyPtZ9ml3lTkG0xfVIyeE6dvaoncEPF2M1yooa60cRckHCvyrsnd0oAVADb4917pYuYuabA1Mi1zb+NsZuHp5FulntDglxLiWQRbz1xmX7Q49lBh19FfllYiWkRaTcATgBIgVw5eVAKYLAdAAATKklEQVR4nO2dC3ubOBaGEREIg7k4jjElOKH4lmLHHdttZjPt//9dq3MkMGDs2JPQ2e7om+fZ1NwkvQjpSDpHq90odS9NV+pempKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKS0vvEbNtkh586/0n/udy8IWrb9v9u7k6LzaMs25WYzVWWRds3CkK5qn9/mehtlEWj3xCzNSWEJIb8ZY75r9R6454lV/XvLxO95dn7/LtTtib8R6afLwbdx8QPlpSOAt8PrisyddjbF525/f+BMtv7hMS9t9qL15gQHyjzq312TZktbTF5D+b/B8rU4fjI6C0MdB/8Tcps6pN/PWXvmf9z8lajzOtyFoa8D6KjiP+9osiUwvP/5ZTte/6vsXPBPf1eD5oVyv/0rkhKUeaG8pz/Y2F3mJSirLEH/jc6GpAYlgVYqGPW6VDWsyzjfHkZa9yDlI2WCy3HNPVT+JlVnjlQNnTTaXmSRnmGrfMvkjbzBUlwGe8yf85LUqZ9MBy0JjY6HY/5kMXa3wxvKsEqhnv7Kc/zZN8ciNFqAXa7T6+1Uwwo91ijlH17N17Mnu/nRy8S36/7c1wOmgrKRi9JZ+n8qE5Y7jLJx/mu32z3Kvmio91uV0tJ13e8MPm37fvMzHMSlPtexv+8HNWO3pAPUnR7zq2J50PO3UnED3D569vaLWbm+xvZfVKNX/CpzLfOT8FNPqpSTDsZEqHwwTp6FustCFkVL1hSdiYx3hDVawW1x7HIV7Cq2fx0xI8/yCQNaBkHlbP2OJAZINuuMPeR8iCF/z0OreqFnPJTDjk4UHYWgGRxMwNoj9WM2REh9/IpTcoRqehAGfvcRTLZxI1Sut/5s+wlHL6vUzaT4jFhv5I4ZfC6sjSNsO2rngGb8+UEZReKEUShX8vWB4vBcG8O+V6Zx2eB8mpLapT1DXB5chzvgecsq36cNcqsRlkzB4MBfC9P/O+gPGzxlP2taxi6x++NKw8Dyhu04Bt1ebTjyc93G8Ayr3xKJtCdDxznCSpOXvku6OtpyvBzuHty3aflzfu65nNCyjB7sW6BLCiHxF9Mkz/lN0gp/8ACF345/D6/OnlzjnK7jdHjGHNky5Z+jQ1QHi/go7mf1NrlfhBsbYPZkPHF4bUgvWe0kdw1Id/dSsJnKLs8yzvMMjV/LrsyX5AyV+y2pQCUYxLt7YM9gTcs8JVgoasgr6bc51U5lm2om9VeNVCekXjnVKwPTDAnW3wXA5636EAZ27EEmxD4QMiFlHu8yozKCnQS0ztVUCbbfstZoEzifpWMkWRZlouLB7xaTyuf5tWUbU42HfRRHu8bfK88BZSJf1sbiiJl/168CsAaHroSfcXzJT449ie/bH9AdoYy5nLSeawvUgaWwb6lUULKSX3Qbdi2Ld+Iy0+P30OZ8QYjGErhtEh5Cik3hqKCsnwT+qpGGdYfpGFJH/mjHg6POleXPZ6D+LHrpQGkfL+Cbrl/nBRQvnNbbhNyh++jjDjuwoMq0yJI+baeJaScSvJWXqfceOyFlOFd8Wdql8ws/H0h5dUA+ueW4TVQfm7rFkGUDt5Zl9knfmTj9UpVWi2gHDdyhJSL0aM1PkGZsisoazpay/7GfXOa7B1CyqmpQVr5EU+0l1tKQg3H6dPX/bm63OwaT1FO26sRUM4aGRKWnKzfbZSpZeqG9ro7QxkHCBXKVAvFSCbpcL1TUNYNNIq3zffZTpk6+2QRDcU46xRlnBi5hPK6fYbKXB9bl0A51k5SZs5jvv4uxoUnKcNttbEfNVfijmzUNjPyIZKUNQcGeEFzCr+VMtNSqPnhOp3Gpykb3y6kHLe3++asvS4PiwccUbYe1+SQr1OUnecGZZ7U47OwZjtbuC0oayaOmxvLUW2UKbQT8fSzbjtPZ1oM7FYu6f389rJdTbkPn2OcjHTTMYenKeNQv05ZY+YDzOOQqKuJ35IyRaut0QO2UXZ4Noe6BWi8M5S98ALKWlwOJZq6ljKFRctI5Iu1UJa/cXqlSZnf4SbQAL6w5omPUUlZYzCnQsa1grVQZjt+1VLkZuAfU5aDXvoaXDgqOWIpdC1lJy3nrmCV/YiyNE2MSStlXsfhLa06Gp8cKAs/AbKr9oAtlGHIJWd16LKl9wvFOR0n8t6ijPOu7ROO11I2OdmhuJ5tW3o/CdCbnaCs2bxxvunIbK5QFrOQfrUHbKFsPpeU3bRJOSuaWcoCmIM+pjyv9eP8MugN2gp9LWV2oOwuGpShmopEeOOd+e2UzRtOuau6vDtQ1mx40WFl8b+tLj8XLYa+a1py2OOlHqWMV5mXJmXNCI7mV3GMQBaebDQr/eC1lGF2T7QYzrxhyWl96CMmDqX6PiC7OuWenAejdli/6SPFflYoUw0mwmeHz6aFMkyj8eKbjj3x/aBOGUcNZDXabyPy7DZbDOzeg1vTMqpDPPh+yPrRMR3d3lfMjatbDHj7zzxf5pzE9VGJmBL3k/0oCUj6WqXMkmHyaup9SweruTsb488KZc34CT3gpixcm42hQ8UYPsOSxK4xwtacDQ5XAxg8HI2wceaBBOn0j2nloIkNOAmf01XmV9K6usUAq5AMF2lI4pcGZVF7SACuU/pjjTKv98F6PJ3eh53ayzXKmoOrPWXjKdb9GneM5OKSP/+rYcnJWV408A0wmf7TmLOXoyxSbRr0xxkpVHkYjP3aKMfFrUB5WMmbtRODURLePjZaDM3YynPDUf+RNCgXWrfNSn6M6CjP88p6l5Pw39Oyi2LGsTsANZPZcBjds77BL2644TqTBVcCy8G7yWTfuNVZptFwOFzXpz8dLbnBu1ila6QPk8nL0Zo6O6zn022eJzWU/Q1/+Hpqstdpnu9r9xq3acZTmOtMe+X5OtzGdjfZd56lLH3o0m+bNhwYwKHhrfG8YXqeDUsc/OJm1pjDhQ849nuAKRDb87ymgUz7Dt5VX5Jmb/jg0WZGqcUfbkKj3z/KF3V4k92WL+bYrgfF6dAdQ0lJSUlJSUlJSUlJSelfI8r4WLnPh7S/YczGbyKq9z7/SKbTZLJ71DofzUsvIts19TcCQC4URGy9/0EMPJs6rGPm40o6sMCMZVfri4VYLDzivnxZp/kP/f1uU2Y2DIeL9z7HGg/D8Htn88u0l/qkoucPWl+kTnuO+9XEyDBvdZu+Rt4dAQ+Bdz5FT8lJz5APkBPJpYrZ94+k7IxmP1uz3CN1vRVb/6Z+B8oOrl5Ey4Fpuu4ujT+GMuuNCXk8TTlyNW2fLPAjWp923L1IvwFl4WkTyxls5pjJ5gMcTNk2hPXkc5QppYb7gJjfGTLzG1Dug8sgyQ95NFq9qa6Ujn4d5yiLtWIHfV5O+kdfpt+AsvBE/+gwt0sp0z38uPParrtYvwFlseTc7g7493UxZfRNj6tL+tcPi34Dyvhwkj21nWO66Xq2c7R8CouhulNfjLQc23PLkDFJ2WhGXINqlMEBhdwVriaG6WrL255bWh39YqGXdxgn0z9QZjwTdtVkoZZjVrIlo9rRwcySQd+0x69wWLeUra9oTm2OP1rLna8W0V20GN8WVoc7GAygtI6Wp4v73cE20Hs5XLpebbn1S73BX+Du7u8eQE3MVcrork8yidydP9/BTkjhai9qJvv29evXb4yf+ZSCZ4bH03cw/elqsdrJl1NQpt4uje6yTfliqb3P0/UwXK8mMlaW/eAP/Mq/MV0bi33HHG08G4aLiet0amPcCqs1dRvOAXZShoCTjcAswpxNaqbS0i3ql52X45p1D0NQK2r6/dV6P+wVhKcLuw0PN03x0bDNARny0XOGjTeG2cwc6q78avqSMnvNxL2B9Ppl9Ll8XrjE4lno+TQ37KkvTBvhPkYg4LlTe9mWWQl3ZpUzvlqSvjzg341+oOz2yrB1EcAqXRiThxzdN71lDTJpNkYVypaGmwyg1wXuHMEff/8Ve4oppNiHBEMdva84ZQcp26x8GyIcWFA293GJFPefoUu4fJg8TDCYEflhSAmZe/iHUzaFIxTkYnXfJWXc6klUjcr+FOgIStIBY7jZgL8vHNx5E77mv2WJ0O8YY19Cz2ImBgDl2v3qHqqVn//B9a3pQCMo/+U4jrsbiqoFh8UHkgx0y5sX5RWUn7COlpSfZo30BeWn6HAY9wdy1phxnVngVisCsQTlT2JLggkTTn3hfLnjtL93SVkzlmXTED0UIZxOuSkD+hyLIHSkvJ5yfCNNuJ1B1hm4nRH0aO0hFVfXB+hi+Vk3uJrpIeU4XSwWWCeDOTZHFNuZFCunvZGPRsrRVNQ3SXnBf/L0H8r0BeWM8xuPtJ/IGSKrhJE4g74Dq0EMxousy+JlTPoYLRBTi4q61CVlzXg97FyR9uTGcpCRAL88CB0RUQxIOQrI1qRUOGp+MaUtKILOHazCS/q2JVcoHjuio0NvUOmfjr6+w4LyMCD+6gWsPqS8DsiOp48RXfyNFpT5lfPyMPiKG/hysKkzsO6OSsrgS5rsS+ZQgSj1O6as0cG47LACsYmBlkVRJILtwMFVhOQxsSfLCv+NrcOQ29l9KKSI2EEPYnDzvJgyiVZLfEEQKkHCAc4862BFQ0PaFwlG1MHVBSeopI/WyV1JGRzNy8MBUE7CKAqxvRIHIS5HcIWGyeAPxHmyWAwVsJSdUub53x+64wRLbdq2fYjcF5tNCMoBBjXSz76gLHCL/eiM6ez5efbjAsrDaZ6PF/KtcQtXxEr5IQa9h3icP0ZQDoodDQRlmf4r/rtslwkRfSjzJWWMybfFZoQ4VwPNv6ScY8MkeiQZ0inqe7eUNWpu1wXmXb0pRcpDrChYaBHPK7BwyiJiQTqDGyYXu2Ts92RZutnbYsc2c+RL86OKSsr3hbkuKKdiZw4cNVYoywg6r6RcKRwrKoKgHIglEVE/ZNwc+/ELKMMuzFu5SVNQ+rNS1nfMJ6AcHyjPZf2QlDGq+bDnrdClI2zm4jeUW6Lzg116ShU2BvlZWD6CcpG+X6cs/doHDcqUWfzF1ylLA1RU329i20EM7+yeMhRZOsoXr9fUttOb9TquUZYZaVBuBKxfSlljouFhGBBQDAJLIeXgtXgMUvZvZfoNytInvEaZ6vrnyWadZXXK0t9f9I/y7YjX/Aso85GQMCQxnIu6u3Vp51coy80yJOWepBzVv9GLKWs2mnM/DSzkl8YCgrCXy5kspBwPZPp1ykN5VZWyxcbhYRx6oCw/PEFZTkf+QsqaPS5aJ0P0h/Ei2dYpF5MOSPmLK7+7YX224grK2B0k1gib2XqQgqRc7iSKlMvZvDrlYk6uQtlMsJaE6SSvU57/w5Qp2sl8SMVwqBJOeo6ln6eMuwI09968nLIY4250GleKXKiN8syU6Tcoy8/gQFlsxzBb6o4I/ztBWfbbv6xdBuGWbJyyLkZxBswvnKcsR+jT2gz1FZTRTp1aaC83m/drKDfrsvjGFk+sCNw8oixmEf6QP36NjSGElP0R7hQmNoUSI9XTlHE/Nn64NnV6OWX3iyg3hj2SuBG/2UL5+ULKOGQlaFtb7S0GhSEmGYsbu7aX+7XgdshbbIoVFNzFQISjn6EsLf1l9WO/3MYQ06SPlOJsiNy/r8zaOyiLISZOCNqLdspYhEz05qLl6oyyF0wPywsisHqli+8Yc+NFb1AWwy0SetU4SZy2/dG6mlh6Cmiwio1GFoC0RWRlbT/Vd1CW8+Y4ZMU5uWPKmimmXeAZIui+O8oDnqnNyHGsvqU7E8wjpdJ691jfwy/5HGW5RQNZi/2zKBRB3D91tKOdhsuxH+xCPtqJqWJYdqSChT8R04L4mPfU5YFAazNLF7P7x5RFe52ZFjMGcqK5Q8qQyXQ6nd6LubmtIRtjsvmRZCSoj0pqlMWHL3acIOFcd21vBLNdwvCItxx8M3hVUPbBU65wzhNLMdZO/EqXrm17y+n+fZTFMkQw3eYhidopi8pMouTHfEZmcfeUDwpwExL9vjyA9e0EZVlkXcZe30UZHwbAjqTSLSy+8xtj72MPLjl3wxHIIb5/l2VffFLMyf1NymKiQ3xluxOUDysYvKkKuqRsf68xTjWRBdHn8wPbJxzmIuW4Qvm1alY588OaXQxDC6oVc9ZHlI1aeutiJRXO9PJheWahlet+xXnHJw1Lzj+i7OF7gmvYUuZpYR8suU2NMm+y5fDW/4HPI53ZGK77kK8W6yhaLza7QdkROvvNLEsTj7F5kiRz7CLu0zTNiyzC4XIUYQweNvCMxeZF9ILUW24WMEl9tN0STQq93LqeWfNFtAbLfJWmq68vrjA2bvl/pQxIv4zDhyfM0VDDbBUbHyZFbjXmzRfZ82Zp0xEcFJv+8gdWnsizOU9n0WzD+liepLLB/EeLdxCO6bpm3cWC6qaNweHMMGQcv6Xrejn6OByWD3Fs165u4gsHXPvYzjAKtcWyU0ij9B6n9f87MDhV1kOjli2reri4xnBsE7wvKByj5RPrueFFx4uMtuUzJSUlJSUlJSUlJSUlJSUlJSUlJSUlJSUlJSUlJSUlJSUlJSUlJSUlJSUlJaX/FelK3Uu7Uepe/wU4Q5qrlW5DiAAAAABJRU5ErkJggg=="
				width=20% height=50%>
			<div style="text-align: right">
				<a href="/adtool/logout"
					onclick="if (!(confirm('Möchten Sie sich wirklich abmelden?'))) return false">Abmelden</a>
				<hr />
			</div>
			<h2 style="text-align: center">AD-Tool</h2>
		</div>
</head>
<body>
	<form:form action="suche" cssClass="form-horizontal" method="post"
		modelAttribute="user">


		<input type="button" id=button value="Benutzer hinzufügen"
			onclick="window.location.href='showForm'; return false;" />

		<form:input path="sucheUsername" cssClass="form-control"
			placeholder="Benutzername" />
		<div style="text-align: center">
			<form:button id="button" name="btnSuche">Suchen</form:button>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Benutzerliste</div>
			</div>
			<div class="panel-body">

				<table class="table table-striped table-bordered">
					<tr>
						<th>Benutzername</th>
						<th>Vorname</th>
						<th>Nachname</th>
						<th>Abteilung</th>
						<th>E-Mail</th>
						<th>PC-Name</th>
						<th>Zustand</th>
						<th>Konto</th>
						<th>Passwort</th>
					</tr>

					<!-- loop over and print our users -->
					<c:forEach var="user" items="${users}">

						<!-- construct an "update" link with user id -->
						<c:url var="updateLink" value="/user/updateForm">
							<c:param name="userId" value="${user.id}" />
						</c:url>

						<!-- construct an "delete" link with user id -->
						<c:url var="deleteLink" value="/user/delete">
							<c:param name="userId" value="${user.id}" />
						</c:url>

						<tr>
							<td>${user.userName}</td>
							<td>${user.firstName}</td>
							<td>${user.surname}</td>
							<td>${user.department}</td>
							<td>${user.email}</td>
							<td>${user.pcName}</td>
							<td>
								<c:choose>
									<c:when test="${user.state}">
											<input disabled="disabled" type="checkbox" style="width: 100%;" checked="false" />
									</c:when>
									<c:otherwise>									
											<input disabled="disabled" type="checkbox" style="width: 100%;" unchecked="true" />
									</c:otherwise>
								</c:choose>							
							</td>		
							<td>
								<c:choose>
									<c:when test="${user.account}">
											<input disabled="disabled" type="checkbox" style="width: 100%;" checked="false" />
									</c:when>
									<c:otherwise>									
											<input disabled="disabled" type="checkbox" style="width: 100%;" unchecked="true" />
									</c:otherwise>
								</c:choose>							
							</td>
							<td><a href="${updateLink}">zurücksetzen</a></td>


							<td>
								<!-- Test Commit --> <!-- display the update link --> <a
								href="${updateLink}">Update</a> | <a href="${deleteLink}"
								onclick="if (!(confirm('Benutzer wirklich löschen?'))) return false">Delete</a>
							</td>

						</tr>

					</c:forEach>

				</table>

			</div>
		</div>
		</div>

		</div>
	</form:form>
</body>

</html>