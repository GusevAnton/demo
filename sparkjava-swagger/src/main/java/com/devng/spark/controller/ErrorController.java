package com.devng.spark.controller;

import static com.devng.spark.dto.JsonUtil.*;
import static spark.Spark.*;

import com.devng.spark.dto.MessageDto;

public class ErrorController {

	public ErrorController() {
		notFound(toJson(new MessageDto("Not found.")));

		internalServerError(toJson(new MessageDto("Internal server error.")));

		exception(IllegalArgumentException.class, (e, req, res) -> {
			res.status(400);
			res.body(toJson(new MessageDto(e)));
		});
	}
}
