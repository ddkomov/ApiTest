import Colors.ColorsData;
import Registration.Register;
import Registration.SuccessReg;
import Registration.UnSuccessReg;
import Spec.Specification;
import Users.UserData;
import Users.UserTime;
import Users.UserTimeResponse;
import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresPojoTest {
    private final static String URL = "https://reqres.in/";

    /**
     * 1. Получить список пользователей со второй страницы reqres.in;
     * 2. Убедиться, что id пользователей содержится в их avatar;
     * 3. Убедиться, что email пользователей имеет окончание reqres.in;
     * */
    @Test
    public void checkAvatarAndIdTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec200());
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        users.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }
// Успешная регистрация.
    @Test
    public void successRegister() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assert.assertNotNull(successReg.getId());
        Assert.assertNotNull(successReg.getToken());

        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());
    }
// Неуспешная регистрация.
    @Test
    public void unSuccessRegTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec400());

        Register user = new Register("sydney@fife", "");
        UnSuccessReg unSuccessReg = given()
                .body(user)
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Missing password", unSuccessReg.getError());
    }

    @Test
    public void sortedYearsTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec200());
        List<ColorsData> colors = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);
        List<Integer> years = colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedYears, years);
    }
    //Успешное удаление.
    @Test
    public void deleteUserTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecUnique(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    public void timeTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecUnique(201));
        UserTime user = new UserTime("morpheus", "zion resident");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .post("api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);
        String regex1 = "(.{5})$";
        String regex2 = "(.{11})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex2, "");
        Assert.assertEquals(currentTime, response.getcreatedAt().replaceAll(regex1, ""));

    }
}
