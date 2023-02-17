package io.github.jihch.mapper.world;

import io.github.jihch.bean.City;
import io.github.jihch.bean.User;
import io.github.jihch.mapper.testdb.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<City> cityList = cityMapper.selectList(null);
        Assertions.assertEquals(true, cityList.size() > 0);
        cityList.forEach(System.out::println);
    }

}
