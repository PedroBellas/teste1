<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<s:head />
	</head>
	<body>
		<form class="d-flex flex-column" action="exame/listar?page=1" method="POST">
            <s:textfield cssClass="d-flex flex-column" name="id" label="Codigo" />
            
            <s:textfield cssClass="d-flex flex-column" name="name" label="Nome do exame" />
            
            <s:select key="" list="#{'all':'Ambos','True':'Ativo', 'False':'Inativo'}" name="active" label="Status" />
            
            <s:submit cssClass="dark-green text-white" value="Buscar" />
        </form>
        
		<table>
			<thead>
				<tr>
					<th>codigo</th>
					<th>Nome</th>
					<th>Ativo</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			
			<s:iterator value="exams" var="exam">
				<tr>
					<td>
						<s:property value="#exam.id"/>
					</td>
					<td>
						<s:property value="#exam.name"/>
					</td>
					<td>
						<s:property value="#exam.active"/>
					</td>
					<td>
						<s:url var="testUrlId" namespace="/exame" action="atualizar">
						    <s:param name="id" value="#exam.id" />
						</s:url>
						
						<s:a errorText="Sorry your request had an error." preInvokeJS="confirm('Are you sure you want to delete this item?')" href="%{testUrlId}">
							Att
						</s:a>
					</td>
					<td>
						delete
					</td>
				</tr>
			</s:iterator>
		</table>
		
		<s:a href="listar?page=%{page - 1}" disabled="%{page == 0}"><</s:a>
		
		<s:select list="pagination.getQtypages()" headerKey="page" value="page" onchange="listar?page=%{page - 1}"/>
		
		<s:a href="listar?page=%{page + 1}" disabled="%{page == pagination.getQtypages().size()}" >></s:a>
	</body>
</html>