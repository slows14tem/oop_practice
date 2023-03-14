package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
        //test를 위해서 PasswordGenerator를 상속받는
        //CorrectFixedPasswordGenerator(항상 성공하는 비밀번호 생성)과
        //WrongFixedPasswordGenerator(항상 실패하는 비밀번호 생성)을 생성하여 UserTest에서 테스트 실행
        //실제 환경에서는 진짜 렌덤으로 진행되지만 테스트환경에서 비밀번호 유효성에 맞는지 테스트하는 코드

        // as-is (내부에서 랜덤 패스워드 생성하는 강한 결합(영향 많이 받음) = 테스트 어려움
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be
        //상위에 인터페이스를 만들어 RandomPasswordGenerator의 의존성(결합)을 느슨하게 함
        String password = passwordGenerator.generatePassword();
        //비밀번호는 최소 8자 이상 12자 이하여야 한다.
        if(password.length() >= 8 && password.length() <=12){
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
