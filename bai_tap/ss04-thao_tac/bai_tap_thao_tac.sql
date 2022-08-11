use quan_ly_sinh_vien;

select * 
from `Subject`
where Credit = (select max(Credit) from `Subject` ) ;

select `Subject`.SubName, Mark.Mark
from `Subject`
join Mark on Mark.SubId = `Subject`.SubId
where Mark.Mark = (select max(Mark.Mark) from Mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

select  Student.StudentName, avg(Mark)
from Student
join Mark on Mark.StudentId = Student.StudentId
group by Student.StudentId
order by Mark.Mark desc;
