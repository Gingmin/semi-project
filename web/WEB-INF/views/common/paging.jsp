<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="page_area">
		<c:choose>
			<c:when test="${ empty requestScope.searchValue }">
				<i id="startBtn" class="fas fa-backward"></i>
				<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
					<i class="fas fa-caret-left"></i>
				</c:if>
				<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
					<i id="prevBtn" class="fas fa-caret-left"></i>
				</c:if>

				<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }"
					end="${ requestScope.pageInfo.endPage }" step="1">
					<c:if test="${ requestScope.pageInfo.pageNo eq p }">
						<button class="btn_detail">
							<c:out value="${ p }" />
						</button>
					</c:if>

					<c:if test="${ requestScope.pageInfo.pageNo ne p }">
						<button class="btn_detail"
							onclick="pageButtonAction(this.innerText);">
							<c:out value="${ p }" />
						</button>
					</c:if>
				</c:forEach>

				<c:if
					test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
					<i class="fas fa-caret-right"></i>
				</c:if>
				<c:if
					test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
					<i id="nextBtn" class="fas fa-caret-right"></i>
				</c:if>
				<i id="endBtn" class="fas fa-forward"></i>
			</c:when>


			<%--검색 했을시 페이징처리 --%>
			<c:otherwise>
				<i id="searchStartBtn" class="fas fa-backward"></i>
				<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
					<i class="fas fa-caret-left"></i>
				</c:if>
				<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
					<i id="searchPrevBtn" class="fas fa-caret-left"></i>
				</c:if>

				<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }"
					end="${ requestScope.pageInfo.endPage }" step="1">
					<c:if test="${ requestScope.pageInfo.pageNo eq p }">
						<button class="btn_detail" disabled>
							<c:out value="${ p }" />
						</button>
					</c:if>

					<c:if test="${ requestScope.pageInfo.pageNo ne p }">
						<button class="btn_detail"
							onclick="searchPageButtonAction(this.innerText);">
							<c:out value="${ p }" />
						</button>
					</c:if>

				</c:forEach>

				<c:if
					test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
					<i class="fas fa-caret-right"></i>
				</c:if>
				<c:if
					test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
					<i id="searchNextBtn" class="fas fa-caret-right"></i>
				</c:if>
				<i id="searchEndBtn" class="fas fa-forward"></i>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>