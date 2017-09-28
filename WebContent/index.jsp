<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>


<c:if test="${not empty usuarioLogado}">
	Logado como ${usuarioLogado.email} <br/>
</c:if>



<form action="executa" method="POST">
	<input type="hidden" name="tarefa" value="NovaEmpresa"/>
	Nome: <input type="text" name="nome">
	<input type="submit" value="enviar"> 
</form>

<form action="login" method="POST">
	Nome: <input type="email" name="email">
	Senha :<input type="password" name="senha">
	<input type="submit" value="Logar"> 
</form>

<form action="executa" method="POST">
	<input type="hidden" name="tarefa" value="Logout"/>
	<input type="submit" value="Deslogar"/>
</form>

</body>
</html>