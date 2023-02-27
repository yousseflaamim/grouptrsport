package com.example.transportmanagement;

import com.example.transportmanagement.modell.CarDetails;
import com.example.transportmanagement.modell.GroupDetails;
import com.example.transportmanagement.modell.MemberDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TransportManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(TransportManagementApplication.class, args);
    }
   @Bean
    public RestGroupById restGroupById(){
       return id -> restTemplate().getForEntity("http://localhost:9093/group/" + id, GroupDetails.class).getBody();
   }

   @Bean
   public RestCarById restCarById(){
        return  id -> restTemplate().getForEntity("http://localhost:9092/cars/"+id, CarDetails.class).getBody();
   }
   @Bean
   public RestMemberById restMemberById(){
        return id -> restTemplate().getForEntity("http://localhost:9091/member/"+id, MemberDetails.class).getBody();
   }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
