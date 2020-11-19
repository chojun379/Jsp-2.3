<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" required="true" fragment="true" %>
<%@ attribute name="level" type="java.lang.Integer" %>
<%
	String headStartTag = null;
	String headEndTag = null;
	if(level == null) {
		headStartTag = "<hl>";
		headEndTag = "</h1>";
	} else if(level == 1) {
		headStartTag = "<hl>";
		headEndTag = "</h1>";
	} else if(level == 2) {
		headStartTag = "<h2>";
		headEndTag = "</h2>";
	} else if(level == 3) {
		headStartTag = "<h3>";
		headEndTag = "</h3>";
	}
%>
<%= headStartTag %>
<jsp:invoke fragment="title"/>
<%= headEndTag %>