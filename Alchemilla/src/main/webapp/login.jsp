<link rel="stylesheet" href ="CSS/estilo.css"/>
<body>
	<div class="bgr">
		<form action="<%=request.getContextPath()%>/login" method="POST">
			<div class="container">
				<div class="row">
					<div class="col" style="width: 100px;">
						<b>Usuario</b>
					</div>
					<div class="col">
						<input type="text" placeholder="Ingrese su Usuario"
							name ="username" requiered>						
					</div>
				</div>
				<div class="row">
					<div class="col">
						<b>Contrase�a</b>
					</div>
					<div class="col">
						<input type="password" placeholder="Ingrese su contrase�a"
						name="password" required>					
					</div>					
				</div>
				<div class="row">
					<div class="col"></div>
					<div class ="col">
						<p class="login_error"><%=request.getAttribute("err") == null ? "": request.getAttribute("err")%>
                                                </p>   
                                                <button type="submit">Ingresar</button>
                                        </div>
				</div>
			</div>		
		</form>		
	</div>
</body>