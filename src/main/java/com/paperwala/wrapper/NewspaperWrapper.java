package com.paperwala.wrapper;

import javax.persistence.Basic;
import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class NewspaperWrapper {

	private String newspaperName;

	private String newspaperRate;

}
