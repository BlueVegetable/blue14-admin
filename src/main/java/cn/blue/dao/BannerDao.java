package cn.blue.dao;

import cn.blue.domain.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {

    int addBanner(Banner banner);

    int deleteBanner(int id);

    int getAllCount(@Param("visible") boolean all);

    List<Banner> getAllBanners(@Param("visible") boolean all);

    int alterVisible(@Param("id") int id,@Param("visible") boolean state);

    int change(@Param("id") int id,@Param("newPosition") int position);

}
