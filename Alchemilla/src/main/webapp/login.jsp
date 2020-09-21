<style>
input{
	width: 200px;
	padding: 12px 20px;
	margin-bottom: 10px;
}

button {
	background-color: #d1cfd0;
	padding: 10px 20px;
	width:200px;
	height: 40px;
}
.container{
	display: table;
	background-color: #fff;
	margin:30%;
	padding: 20px 0px 20px 90px;
}

.row{
	display: table-row;
}
.col{
	display: table-row;
}
.bgr{
	display: block;
	position:fixed;
	width: 100%;
	height: 100%;
	background-color: rgba(0,0,0,0.5);
}
.table{
	display: table;
}
</style>

<body>
	<div class="bgr">
		<form action="<%=request.getContextPath()%>/login">
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
						<b>Contraseña</b>
					</div>
					<div class="col">
						<input type="password" placeholder="Ingrese su contraseña"
						name="password" required>					
					</div>					
				</div>
				<div class="row">
					<div class="col"></div>
					<div class ="col">
						<button type="submit">Login</button>
					</div>
				</div>
			</div>		
		</form>		
	</div>
</body>