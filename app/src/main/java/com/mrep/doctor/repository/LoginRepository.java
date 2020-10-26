package com.mrep.doctor.repository;

//import com.mrep_doctor.doctor.networking.LoginAPI;


public class LoginRepository {

    private static LoginRepository loginRepository;

    public static LoginRepository getInstance() {
        if (loginRepository != null)
            loginRepository = new LoginRepository();
        return loginRepository;
    }

//    private LoginAPI loginAPI;

//    public LoginRepository(){
//        loginAPI = MRepRetrofitService.cteateService(LoginAPI.class);
//    }

//    public MutableLiveData<LoginModel> getLogin(String source,String  key){
//        MutableLiveData<LoginModel> newsData = new MutableLiveData<>();
//        loginAPI.getNewsList("","")
//    }
}
