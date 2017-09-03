<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id=PageSelectorBar>
	<div id=PageSelectorMemo>页次：${currentPage }/${pageCount }页 &nbsp;
		每页显示：${pageSize }条 &nbsp; 总记录数：${recordCount }条</div>
	<div id=PageSelectorSelectorArea>
		<!--
				<IMG SRC="${pageContext.request.contextPath }/style/blue/images/pageSelector/firstPage2.png"/>
				-->
		<a href="javascript:void(0)" title="首页" style="cursor: hand;"> <img
			src="${pageContext.request.contextPath }/style/blue/images/pageSelector/firstPage.png" /></a>

		<s:iterator begin="${beginPageIndex }" end="${endPageIndex }"
			var="num">
			<s:if test="#numm == currentPage">
				<span class="PageSelectorNum PageSelectorSelected">${num }</span>
			</s:if>
			<s:else>
				<span class="PageSelectorNum" style="cursor: hand;"
					onClick="gotoPageNum(${num});">${num }</span>
			</s:else>
		</s:iterator>

		<!--
				<IMG SRC="${pageContext.request.contextPath }/style/blue/images/pageSelector/lastPage2.png"/>
				-->
		<a href="javascript:gotoPageNum(${pageCount});" title="尾页"
			style="cursor: hand;"> <img
			src="${pageContext.request.contextPath }/style/blue/images/pageSelector/lastPage.png" /></a>

		转到： <select onChange="gotoPage(this.value)" id="_pn">
			<s:iterator begin="1" end="${pageCount}" var="num">
				<option value="${num}">${num}</option>
			</s:iterator>
		</select>
		<script type="text/javascript">
					$("#_pn").val("${currentPage}")
		</script>
	</div>
</div>

		<script type="text/javascript">
			function gotoPage(pageNum) {
				//window.location.href = "topic_show.action?id=${id}&pageNum="+pageNum;
				$(document.forms[0]).append("<input type='hidden' name='pageNum' value='"+pageNum+"'");
				document.forms[0].submit();
			}
		</script>