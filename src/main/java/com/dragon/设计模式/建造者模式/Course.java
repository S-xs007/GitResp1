package com.dragon.设计模式.建造者模式;

import lombok.Data;


@Data
public class Course {
    private String CourseName;
    private String ppt;
    private String video;
    private String note;

    public static class CourseBuilder{          //利用静态内部类完成建造者模式
        private Course course = new Course();
        public CourseBuilder addVideo(String video){
            course.setVideo(video);
            return this;
        }
        public CourseBuilder addNote(String note){
            course.setNote(note);
            return this;
        }
        public CourseBuilder addName(String n){
            course.setCourseName(n);
            return this;
        }
        public CourseBuilder addPPT(String ppt){
            course.setPpt(ppt);
            return this;
        }
        public Course build(){
            return course;
        }
    }


}
class Test{
    public static void main(String[] args) {
        Course.CourseBuilder builder = new Course.CourseBuilder();
        Course course = builder.addName("java").addNote("111").addVideo("wu").build();
        System.out.println(course.toString());
    }
}
