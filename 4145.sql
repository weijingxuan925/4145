<!DOCTYPE html>
<html>
<head>
	<title>PDF Viewer</title>
	<style>
		.pdf-container {
			position: relative;
			width: 100%;
			height: 100%;
			padding-bottom: 141%; /* 设置为 A4 纵横比 */
			background-color: #fff; /* 将背景色设置为白色，使 PDF 在其边缘周围留出空白边距 */
		}
		.pdf-container embed {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
		}
	</style>
</head>
<body>
<h1 style="text-align: center;">PDF Viewer</h1>
<p style="text-align: center;"><strong><a href="http://webapp-1510807245.us-east-1.elb.amazonaws.com/upload/project/Project report.pdf" download="">Download PDF</a></strong></p>
		<div class="pdf-container"><embed src="http://webapp-1510807245.us-east-1.elb.amazonaws.com/upload/project/Project report.pdf" type="application/pdf" width="300" height="150"></embed></div>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
	<title>PDF Viewer</title>
	<style>
		.pdf-container {
			position: relative;
			width: 100%;
			height: 100%;
			padding-bottom: 141%; /* 设置为 A4 纵横比 */
			background-color: #fff; /* 将背景色设置为白色，使 PDF 在其边缘周围留出空白边距 */
		}
		.pdf-container iframe {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
		}
		.pdf-container embed {
			display: block;
			margin-left: auto;
			margin-right: auto;
			max-width: 100%;
			height: 100%;
		}
	</style>
	<script>
		if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
			// 如果是手机，则使用 iframe 来嵌入 Google Docs 预览器
			document.write('<meta name="viewport" content="width=device-width, initial-scale=1">');
			document.write('<style>body {margin: 0; padding: 0;}</style>');
			document.write('<div class="pdf-container"><iframe src="https://docs.google.com/gview?url=http://webapp-1510807245.us-east-1.elb.amazonaws.com/upload/project/Project report.pdf&embedded=true" frameborder="0"></iframe></div>');
		} 
    else {
			// 如果不是手机，则使用 embed 来嵌入 PDF 文件
			<div class="pdf-container"><embed src="http://webapp-1510807245.us-east-1.elb.amazonaws.com/upload/project/Project report.pdf" type="application/pdf" width="300" height="150"></embed></div>
		}
	</script>
</head>
<body>

</body>
</html>