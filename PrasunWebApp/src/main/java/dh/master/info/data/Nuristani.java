package dh.master.info.data;

public class Nuristani {

	private String heading;
	private String text;
	private String annotation;


	public String getAnnotation() {
		return annotation;
	}


	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getHeading() {

		return heading;
	}


	public void setHeading(String heading) {

		this.heading = heading;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Nuristani [heading=" + heading + ", text=" + text + ", annotation=" + annotation + "]";
	}
}
