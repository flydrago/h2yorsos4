<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>${subjectInfo.subject_name}</title>
<link href="<%=uiPath%>common/css/page_mp_article21bc97.css" rel="stylesheet" type="text/css"/>
</head>
<body id="activity-detail" class="zh_CN ">

	<div class="rich_media ">

		<div class="rich_media_inner">
		
			<div id="page-content">
				<div id="img-content">
					<div class="rich_media_content" id="js_content">
						${subjectInfo.subject_content}
					</div>
				</div>
				<div id="js_ad_area"></div>
				<div id="js_iframetest" style="display:none;"></div>
			</div>
		</div>
	</div>
</body>
</html>
