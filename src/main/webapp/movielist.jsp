<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MovieStore MVC</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.min.js"></script>
</head>

<body>
	<div class="container">
		<h1>Movies</h1>
		<c:if test="${message.info != null}">
			<div class="alert alert-success" role="alert">${mvc.encoders.html(message.info)}</div>
		</c:if>
		<c:if test="${not empty message.errors}">
			<div class="alert alert-danger" role="alert">
				<ul class="list-unstyled">
					<c:forEach var="error" items="${message.errors}">
						<li>${mvc.encoders.html(error)}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>

		<table class="table table-striped">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<thead>
				<tr>
					<th class="text-left"></th>
					<th class="text-left">Title</th>
					<th class="text-center">Release Date</th>
					<th class="text-center">Running Time</th>
					<th class="text-center">Country</th>
					<th class="text-center">Genre</th>
					<th class="text-center">Actors</th>
					<th class="text-center"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="movie" items="${movies}">
					<tr>
						<td class="text-left"><c:if test="${not empty movie.youTubeVideoId}">
								<a href="https://www.youtube.com/watch?v=${movie.youTubeVideoId}"
								   target="_blank"> <img
								   src="http://img.youtube.com/vi/${movie.youTubeVideoId}/hqdefault.jpg"
								   width="50" />
								</a>
							</c:if></td>
						<td class="text-left">${mvc.encoders.html(movie.title)}</td>
						<td class="text-center">${mvc.encoders.html(movie.releaseDate)}</td>
						<td class="text-center">${mvc.encoders.html(movie.runningTime)}</td>
						<td class="text-center">${mvc.encoders.html(movie.country)}</td>
						<td class="text-center">${mvc.encoders.html(movie.genre)}</td>
						<td class="text-left">
							<c:forEach var="actor" items="${movie.actors}">
								${actor.name} ${actor.surname} (${actor.age})<br/>
							</c:forEach>
						</td>
						<td class="text-center">
							<form action="${mvc.basePath}/movies/delete" method="POST">
								<input type="hidden" name="id" value="${movie.id}" /> <input
									type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}" />
								<button type="submit" class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form action="${mvc.basePath}/movies/create" method="POST" class="form-inline">
			<div class="form-group">
				<input type="text" class="form-control" id="title" name="title" placeholder="Title" value="${form.title}" autofocus>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" style="width: 120px;" id="releaseDate" name="releaseDate" placeholder="Release Date" value="${form.releaseDate}" autofocus>
				<script type="application/javascript">
		            $(function () {
		              $('#releaseDate').datepicker({
		                orientation: "top auto",
		                format: "yyyy-mm-dd",
		                clearBtn: true,
		                autoclose: true
		              });
		            });
				</script>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" style="width: 120px;" id="runningTime" name="runningTime" placeholder="Running Time" value="${form.runningTime}" autofocus>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" style="width: 150px;" id="country" name="country" placeholder="Country" value="${form.country}" autofocus>
			</div>
			<div class="form-group">
				<select name="genre" class="form-control" title="Genre">
					<option value="">- Genre -</option>
					<option value="ACTION" ${form.genre == 'ACTION' ? 'selected' : ''}>ACTION</option>
					<option value="ADVENTURE" ${form.genre == 'ADVENTURE' ? 'selected' : ''}>ADVENTURE</option>
					<option value="COMEDY" ${form.genre == 'COMEDY' ? 'selected' : ''}>COMEDY</option>
					<option value="CRIME" ${form.genre == 'CRIME' ? 'selected' : ''}>CRIME</option>
					<option value="DRAMA" ${form.genre == 'DRAMA' ? 'selected' : ''}>DRAMA</option>
					<option value="FANTASY" ${form.genre == 'FANTASY' ? 'selected' : ''}>FANTASY</option>
					<option value="HISTORICAL" ${form.genre == 'HISTORICAL' ? 'selected' : ''}>HISTORICAL</option>
					<option value="HORROR" ${form.genre == 'HORROR' ? 'selected' : ''}>HORROR</option>
					<option value="MYSTERY" ${form.genre == 'MYSTERY' ? 'selected' : ''}>MYSTERY</option>
					<option value="PHILOSOPHICAL" ${form.genre == 'PHILOSOPHICAL' ? 'selected' : ''}>PHILOSOPHICAL</option>
					<option value="POLITICAL" ${form.genre == 'POLITICAL' ? 'selected' : ''}>POLITICAL</option>
					<option value="ROMANCE" ${form.genre == 'ROMANCE' ? 'selected' : ''}>ROMANCE</option>
					<option value="SAGA" ${form.genre == 'SAGA' ? 'selected' : ''}>SAGA</option>
					<option value="SATIRE" ${form.genre == 'SATIRE' ? 'selected' : ''}>SATIRE</option>
					<option value="SCIENCE_FICTION" ${form.genre == 'SCIENCE_FICTION' ? 'selected' : ''}>SCIENCE FICTION</option>
					<option value="THRILLER" ${form.genre == 'THRILLER' ? 'selected' : ''}>THRILLER</option>
					<option value="WESTERN" ${form.genre == 'WESTERN' ? 'selected' : ''}>WESTERN</option>
				</select>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" style="width: 120px;" id="youTubeVideoId" name="youTubeVideoId" placeholder="YouTube Id" value="${form.youTubeVideoId}" autofocus>
			</div>
			<input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}" />
			<button type="submit" class="btn btn-primary">Create</button>
		</form>
	</div>
</body>
</html>