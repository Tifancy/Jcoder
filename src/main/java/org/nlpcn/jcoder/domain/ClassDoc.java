package org.nlpcn.jcoder.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * api 的信息类
 * 
 * @author ansj
 *
 */

public class ClassDoc extends ApiDoc {

	public ClassDoc(String name) {
		super(name);
	}

	private boolean single = true;

	private boolean status = true;
	
	private String version ;

	private String description;

	public boolean isSingle() {
		return single;
	}

	public void setSingle(boolean single) {
		this.single = single;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public class MethodDoc extends ApiDoc {
		public MethodDoc(String name) {
			super(name);
		}

		private boolean defaultExecute;

		private String retrunContent;

		private Set<String> methods = new HashSet<>();
		
		public boolean isDefaultExecute() {
			return defaultExecute;
		}

		public void setDefaultExecute(boolean defaultExecute) {
			this.defaultExecute = defaultExecute;
		}

		public String getRetrunContent() {
			return retrunContent;
		}

		public void setRetrunContent(String retrunContent) {
			this.retrunContent = retrunContent;
		}

		public Set<String> getMethods() {
			return methods;
		}

		public void setMethods(Set<String> methods) {
			this.methods = methods;
		}

		public void addMethod(String method) {
			methods.add(method);
		}

		public class ParamDoc extends ApiDoc {

			private String fieldName;

			private String type;

			public ParamDoc(String name) {
				super(name);
			}

			public String getFieldName() {
				return fieldName;
			}

			public void setFieldName(String fieldName) {
				this.fieldName = fieldName;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			@Override
			public ApiDoc createSubDoc(String name) {
				return null;
			}
		}

		@Override
		public ApiDoc createSubDoc(String name) {
			ParamDoc paramDoc = new ParamDoc(name);
			if (sub == null) {
				sub = new ArrayList<>();
			}
			sub.add(paramDoc);
			return paramDoc;
		}
	}

	@Override
	public ApiDoc createSubDoc(String name) {
		MethodDoc methodDoc = new MethodDoc(name);
		if (sub == null) {
			sub = new ArrayList<>();
		}
		sub.add(methodDoc);
		return methodDoc;
	}

}

