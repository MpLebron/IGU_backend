package com.example.demo;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.MemberEntity;
import com.example.demo.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Member;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    MemberDao memberDao;

    @Autowired
    UserDao userDao;

    @Test
    void addNewMemberId(){
        int num2020 = 1;
        int num2021 = 1;
        List<MemberEntity> memberEntityList = mongoTemplate.findAll(MemberEntity.class);
        Iterator<MemberEntity> memberEntityIterator = memberEntityList.iterator();
        while(memberEntityIterator.hasNext()){
            MemberEntity memberEntity = memberEntityIterator.next();
            String regis_year = memberEntity.getRegisterTime();
            regis_year = regis_year.substring(0,4);
            if(memberEntity.getMemberId()==null){
                String newMemberId;
                if("2020".equals(regis_year))
                    newMemberId = "IGU-MGSC-"+regis_year+"-"+String.format("%04d",num2020++);
                else
                    newMemberId = "IGU-MGSC-"+regis_year+"-"+String.format("%04d",num2021++);
                Query query = new Query(Criteria.where("_id").is(memberEntity.getId()));
                Update update = Update.update("memberId",newMemberId);

                mongoTemplate.upsert(query,update,MemberEntity.class);
                System.out.println(newMemberId);

            }
        }
    }
    @Test
    void addMemberIdTo2020(){
        List<UserEntity> userEntityList = mongoTemplate.findAll(UserEntity.class);
        Iterator<UserEntity> userEntityIterator = userEntityList.iterator();
        while(userEntityIterator.hasNext()){
            UserEntity userEntity = userEntityIterator.next();
            System.out.println(userEntity.getMemberId());
            if(userEntity.getMemberId()!=null){
                Query query =new Query(Criteria.where("_id").is(userEntity.getMemberId()));
                MemberEntity memberEntity = mongoTemplate.findOne(query,MemberEntity.class);
                System.out.println(userEntity.getUserName());
                Query query1 = new Query(Criteria.where("memberId").is(userEntity.getMemberId()));
                Update update = Update.update("memberId",memberEntity.getMemberId());

                mongoTemplate.upsert(query1,update,UserEntity.class);
            }

        }



    }
    @Test
    void contextLoads() {

    }

}
