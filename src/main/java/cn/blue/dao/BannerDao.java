package cn.blue.dao;

import cn.blue.domain.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {

    int addBanner(Banner banner);

    int deleteBanner(int id);

    int getAllCount(@Param("visible") boolean visible);

    List<Banner> getAllBanners(@Param("visible") boolean visible);

    Banner getBannerById(int id);

    int getPositionById(int id);

    int bigger(int bannerId);

    int smaller(int bannerId);

    int getMaxBannerPosition();

    String getBannerPath(int imageName);

    int alterVisible(@Param("id") int id,@Param("visible") boolean state);

    int change(@Param("id") int id,@Param("newPosition") int position);

}
