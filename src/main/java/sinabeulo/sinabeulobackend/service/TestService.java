package sinabeulo.sinabeulobackend.service;

import org.springframework.stereotype.Service;
import sinabeulo.sinabeulobackend.model.dto.TestUserInfoDto;

@Service
public class TestService {

    public String myName(String name) {
        if (name != null) {
            return "my name is " + name;
        } else {
            return "name param is null";
        }
    }

    public String myAge(Integer age) {
        if (age != null) {
            return "my age is " + age;
        } else {
            return "age param is null";
        }
    }

    public String myRole(String role) {
        if (role != null) {
            return "my role is " + role;
        } else {
            return "role param is null";
        }
    }

    public String myInfo(TestUserInfoDto userInfoDto){
        userInfoDto.setName("test");
        return myName("name : " + userInfoDto.getName()) + "\nage : " + myAge(userInfoDto.getAge()) + "\nrole : " + myRole(userInfoDto.getRole());
    }

    public String myInfoWithaddress(String address, TestUserInfoDto userInfoDto){
        return myInfo(userInfoDto) + "\naddress : " + address;
    }
}