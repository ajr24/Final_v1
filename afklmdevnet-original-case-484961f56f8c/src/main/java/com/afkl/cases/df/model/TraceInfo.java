package com.afkl.cases.df.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TraceInfo {
	
	private Info info;
	
	

	public Info getInfo() {
		return info;
	}



	public void setInfo(Info info) {
		this.info = info;
	}



	private class Info {

		private String path;
		private Headers header;

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public Headers getHeader() {
			return header;
		}

		public void setHeader(Headers header) {
			this.header = header;
		}

		private class Headers {
			private Response response;

			public Response getResponse() {
				return response;
			}

			public void setResponse(Response response) {
				this.response = response;
			}

			private class Response {
				private String status;

				public String getStatus() {
					return status;
				}

				public void setStatus(String status) {
					this.status = status;
				}

			}

		}
	}
}
