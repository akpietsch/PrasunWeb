package dh.master.info.data;

import java.util.List;

public class Nuristani {

	public String heading;
	public String text;
	public String annotation;

	public List<String> nuristaniList;

	public String toString() {
		return "Nuristani [heading=" + heading + ", text=" + text + ", annotation=" + annotation + "]";
	}

	public List<String> getNuristaniList() {
		return nuristaniList;
	}

	public void setNuristaniList(List<String> nuristaniList) {
		this.nuristaniList = nuristaniList;
	}

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

	public void setText(String content) {
		this.text = content;
	}

}
