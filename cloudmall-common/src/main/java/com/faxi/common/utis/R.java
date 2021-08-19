/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.faxi.common.utis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author fox
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private int code;

	@Getter
	@Setter
	private String msg;

	@Getter
	@Setter
	private T data;

	public static <T> R<T> ok() {
		return restResult(null, HttpStatus.SC_OK, null);
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, HttpStatus.SC_OK, null);
	}

	public static <T> R<T> ok(T data, String msg) {
		return restResult(data,  HttpStatus.SC_OK, msg);
	}

	public static <T> R<T> failed() {
		return restResult(null, HttpStatus.SC_INTERNAL_SERVER_ERROR, null);
	}

	public static <T> R<T> failed(String msg) {
		return restResult(null, HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}

	public static <T> R<T> failed(T data) {
		return restResult(data, HttpStatus.SC_INTERNAL_SERVER_ERROR, null);
	}

	public static <T> R<T> failed(T data, String msg) {
		return restResult(data, HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}

    public static <T> R<T> failed(T data,int code, String msg) {
        return restResult(data, code, msg);
    }

	private static <T> R<T> restResult(T data, int code, String msg) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}

    //利用fastjson进行反序列化
    public <T> T getData(TypeReference<T> typeReference) {
        Object data = this.getData();	//默认是map
        String jsonString = JSON.toJSONString(data);
        T t = JSON.parseObject(jsonString, typeReference);
        return t;
    }

    //利用fastjson进行反序列化
    public <T> T getData(String key,TypeReference<T> typeReference) {
        Object data = this.getData();	//默认是map
        String jsonString = JSON.toJSONString(data);
        T t = JSON.parseObject(jsonString, typeReference);
        return t;
    }

}
