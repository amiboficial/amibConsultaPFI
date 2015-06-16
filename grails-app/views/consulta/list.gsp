
<%@ page import="consultapfi.Consulta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'consulta.label', default: 'Consulta')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
		<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.css">

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/1.10.6/integration/bootstrap/3/dataTables.bootstrap.css">
  
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/plug-ins/1.10.6/integration/bootstrap/3/dataTables.bootstrap.js"></script>

  
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.js"></script>


<g:javascript src="anuncioCarrusel.js"/>
			
		
	</head>
<br>
<br>
	<body>
	<br>
		<center>
		<h1>Consultador de personal Certificado PFI</h1>
		</center>
		<br>
		
		<div class="hola">
		<div id="list-consulta" class="content scaffold-list" role="main">
			<h1></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			
			<table border="0" id="tblArticulos" class="display compact" cellspacing="0" width="100%">
				<thead>
					<tr>
					<th>Matricula</th>
					<th>Nombre</th>
					<th>Ap. Paterno</th>
					<th>Ap. Materno</th>
					<th>Institución</th>
					<th>Figura</th>
					<th>Resultado</th>
					<th>Puntaje</th>
					<th>Fecha inicio</th>
					<th>Fecha fin</th>
					<th>Modalidad</th>
					
						
						
						<%-- <g:sortableColumn property="apeMat" title="${message(code: 'consulta.apeMat.label', default: 'Ape Mat')}" />
					
						<g:sortableColumn property="apePat" title="${message(code: 'consulta.apePat.label', default: 'Ape Pat')}" />
					
						<g:sortableColumn property="fechaFi" title="${message(code: 'consulta.fechaFi.label', default: 'Fecha Fi')}" />
					
						<g:sortableColumn property="fechaIn" title="${message(code: 'consulta.fechaIn.label', default: 'Fecha In')}" />
					
						<g:sortableColumn property="fig" title="${message(code: 'consulta.fig.label', default: 'Fig')}" />
					
						<g:sortableColumn property="inst" title="${message(code: 'consulta.inst.label', default: 'Inst')}" />--%>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${consultaInstanceList}" status="i" var="consultaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: consultaInstance, field: "mat")}</td>
						
						<td>${fieldValue(bean: consultaInstance, field: "nom")}</td>
						
						<td>${fieldValue(bean: consultaInstance, field: "apePat")}</td>
					
						<td>${fieldValue(bean: consultaInstance, field: "apeMat")}</td>
						
						<td>${fieldValue(bean: consultaInstance, field: "inst")}</td>
						
						<td>${fieldValue(bean: consultaInstance, field: "fig")}</td>
						
						<td>${fieldValue(bean: consultaInstance, field: "result")}</td>
						
						<td>${fieldValue(bean: consultaInstance, field: "punt")}</td>
					
						<td>${fieldValue(bean: consultaInstance, field: "fechaIn")}</td>
					
						<td>${fieldValue(bean: consultaInstance, field: "fechaFi")}</td>
					
						<td>${fieldValue(bean: consultaInstance, field: "mod")}</td>
					
					
					</tr>
				</g:each>
				</tbody>
			</table>
			
		</div>
		<br>
	</div>
	</body>
</html>
