package com.example.demo.student;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentRepository {
	@Select("select * from students")
	public List<Student> findAll();

	@Select("SELECT * FROM students WHERE id = #{id}")
	public Student findById(long id);

	@Delete("DELETE FROM students WHERE id = #{id}")
	public int deleteById(long id);

	@Insert("INSERT INTO students(id, name, passport) VALUES (#{id}, #{name}, #{passport})")
	public int insert(Student student);

	@Update("Update students set name=#{name}, passport=#{passport} where id=#{id}")
	public int update(Student student);

}