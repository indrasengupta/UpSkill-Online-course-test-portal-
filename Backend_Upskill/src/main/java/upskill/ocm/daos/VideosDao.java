package upskill.ocm.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import upskill.ocm.entities.Videos;

public interface VideosDao extends JpaRepository<Videos, Integer> {
	@Modifying
	@Query(value="insert into videos(video,course_id,v_name) values(?,?,?)",nativeQuery=true)
	public void addVideos(String video,int courseId,String vName);
}
