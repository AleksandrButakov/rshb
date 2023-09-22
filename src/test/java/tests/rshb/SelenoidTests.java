package tests.rshb;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelenoidTests {

    @Test
    @Tag("api")
    void checkTotal() {
        given()
                .when()
                .get("http://62.113.108.218:8080/status")
                .then()
                .body("state.total", is(5));
    }

    @Test
    @Tag("api")
    void checkWithAllLogsTotal() {
        given()
                .log().all()
                .when()
                .get("http://62.113.108.218:8080/status")
                .then()
                .log().all()
                .statusCode(200)
                .body("state.total", is(5));
    }

    @Test
    @Tag("api")
    void checkWithSomeLogsTotal() {
        given()
                .log().uri()
//                .log().body() // for post() requests
                .when()
                .get("http://62.113.108.218:8080/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("state.total", is(5));
    }

    @Test
    @Tag("api")
    void checkChromeVersion() {
        given()
                .log().uri()
                .when()
                .get("http://62.113.108.218:8080/status")
                .then()
                .log().status()
                //.log().body()
                .statusCode(200)
                .body("state.browsers.chrome", hasKey("112.0"));
    }

    @Test
    @Tag("api")
    void checkResponseBadPractice() {
        String expectedResponse = "{\"state\":{\"total\":5,\"used\":0,\"queued\":0,\"pending\":0,\"browsers\":{\"chrome\":{\"112.0\":{},\"95.0\":{}},\"firefox\":{\"112.0\":{},\"95.0\":{}}},\"videos\":[\"00985843b63df164a573c754ea625f95.mp4\",\"013002a6-c1b8-444b-9135-59ae8297a6fe.mp4\",\"01c8fb2e-d4da-4c4a-85fe-b7198ec3ffbd.mp4\",\"02174089-a700-4998-a05b-6e8ac087dc6a.mp4\",\"0243ab4895dfdb8974f98e38081f990e.mp4\",\"02c41b7f78460ca10dd4b7b407dfcb05.mp4\",\"034e83f097019b1a647c08950271bb0c.mp4\",\"039ba63ee59399b07f9f50d4e061c081.mp4\",\"05086cd82f25f4f890a9dc177f84169d.mp4\",\"07d8d8cbeca37905501846ca4957510c.mp4\",\"0a395f4999d998c05b49108146db4f35.mp4\",\"0a432506-85ce-4841-8d88-08ad54c62e3f.mp4\",\"0e886ba8-a9f3-41b1-b24d-ce6d83495dec.mp4\",\"0eb7e23196d26dcedd8cec925e6a9174.mp4\",\"0ed0cdcd3c3d18c5751d3c3f18d7794f.mp4\",\"0fe39614b1dbdce16d54433939b091d3.mp4\",\"1031a3f5-4367-42a5-895a-96845195a686.mp4\",\"117a8e6e0499ac789e005ac3093fba6f.mp4\",\"11a2c85e4edc56f07667a9ead2607f32.mp4\",\"11f50f6f-30f8-46be-99bc-69c99fbeea83.mp4\",\"12246d05-765a-4e22-8a91-7b02baa8770d.mp4\",\"128524c7092961c423560fbb2a7e07fc.mp4\",\"12da9ab4bb9317c3c416b7a22cadd0a9.mp4\",\"135652fa7c4d5741917972eb39ff04eb.mp4\",\"136ea93c49ae47e81e11740de467d27c.mp4\",\"147c34addcfad3d4ddcb348f700ecd2a.mp4\",\"162e5a7fda4079d3f729714f09fcc383.mp4\",\"17b0b7605727b042be49d5df2d3b0523.mp4\",\"17ba87b1465875ae74dc2bd5843d5c7d.mp4\",\"189f8e7d-db87-4fc1-892a-bf41a2e2dac9.mp4\",\"18b58593a5083420e4651ba9638a7d99.mp4\",\"1999f405-b0f5-4c66-9f3f-41a5dfac7cc0.mp4\",\"19ae879673fbb5ada9aa59ce81f58715.mp4\",\"1a609915-e76e-4129-822e-a469d716534b.mp4\",\"1aed31ee-9ef8-44ab-9f7d-508c1f6a9d43.mp4\",\"1b3fa0a80bc3177cdcd3bf416c4ff3a9.mp4\",\"1b756fe5-5331-40e3-8d36-5df15c4d5659.mp4\",\"1b8f87c3-c18d-4897-9588-1c93e16ee9c7.mp4\",\"1bd2105d-d25e-4216-b48a-a35b5d9e315e.mp4\",\"1c00ebf8-bfad-4bd1-bef4-5c9f45d5fec0.mp4\",\"1ccb5a4b-0e88-406a-a971-c032eaa0ebef.mp4\",\"1cd4cc5b21d02130c0182f944d2427fa.mp4\",\"1d161599-1cc2-4d6c-957d-b85e735bff20.mp4\",\"1d369733a195bb1f5dff726df3bd9d63.mp4\",\"1da8eaeaa2373f3fc867d27e6f4842e9.mp4\",\"1e06129e-c0d9-47f0-ae0b-0ebb996de9e1.mp4\",\"1f0cd197b36e7b81ef1bb4137e88b38e.mp4\",\"1fd3e95e943dcb87314c25857e1c6408.mp4\",\"210ef7c1-6bfc-4609-ab15-4306ae03715a.mp4\",\"2212b9a4-cbbb-4dce-84eb-dc402da8caf6.mp4\",\"22c22e05-0156-4186-9ff9-687431b7e985.mp4\",\"22e8fac8f1262d48e7a97733121846e0.mp4\",\"245434fe-cdb7-4fc1-871c-ba944998543d.mp4\",\"249c9da8-57df-4cbe-a801-a35ec2a0be5b.mp4\",\"254d63c7ae740e534666d3624f3c51e8.mp4\",\"260f3ff6567e68cfbd5a5e57c498ce99.mp4\",\"26306777-e1e7-4569-bf4c-0adaab0390ba.mp4\",\"2701faae-f306-481b-8f1c-0a47bfe58fd2.mp4\",\"2720e51f-2988-4b4b-84d2-258e4d9e6c19.mp4\",\"2878ac1f1923b5cc2e4be1f102968f82.mp4\",\"28c34ae5cebe41669e97f5b043333308.mp4\",\"292ff15a1beb40a23978742c1a29f725.mp4\",\"293ed02bedffcc6baac249936b8efc75.mp4\",\"299451a6d2865fef8e754ee2f838486e.mp4\",\"2b488e9193eba1b9af8dcb710dfe0c6d.mp4\",\"2bc4cc19-8ab8-4506-8701-e209936a2b97.mp4\",\"2c095ece-1da4-4411-9887-2ecf9834bbbb.mp4\",\"2caa3ba64bf7824c5c71c8c26faeec86.mp4\",\"2f6174b93dc04126d3b185e3f7b1df97.mp4\",\"301e172c-aa26-41a4-9266-55f3cdce5c2d.mp4\",\"31ca4002d5e8596c7fbc5a4f48e78586.mp4\",\"322fc3eb-bf52-4118-9ae1-fb1bcb9037ac.mp4\",\"328d6d25-c8e1-4c7c-804e-f10dfc750e12.mp4\",\"32df59cf-87ba-4622-8013-73a67ebf4d3c.mp4\",\"33852aa3-9f35-40d6-bf09-57f6ccce577c.mp4\",\"33da66bc-11bd-4490-898b-3268bcea16d2.mp4\",\"33fe7f89-237b-4259-b432-e168f43189aa.mp4\",\"34083f1e3e6dc67738af2fff62a16b0e.mp4\",\"36cf66dcbe9db21db6a7d9e72fc290e8.mp4\",\"383184c0-a862-4621-9b88-673af263e922.mp4\",\"38be6948-d955-4e4b-95ba-4888bc00b9f8.mp4\",\"38bf63d4-cb6d-4cd8-b422-a21df4be306f.mp4\",\"3922c9905fb527f9acd85de004a2490b.mp4\",\"393cc0e1-6863-40aa-b43e-d23126bd01d2.mp4\",\"3992a1ce-ab26-4777-a6f9-1075d279eb3e.mp4\",\"39d08bc4ff46cc7479d64bb225bb336e.mp4\",\"3a7dc5bfdcdefa377fa58694daa64354.mp4\",\"3b2c4069-2044-42f6-8f0c-d86ac81e94e6.mp4\",\"3b7fe21e-7c95-4e2c-b5e8-42b215531d6a.mp4\",\"3e7bcef9-691f-498b-873f-6ece8009bdb7.mp4\",\"3ee9e961fa6f2a155782271359b43171.mp4\",\"400069072e9ce5e9d0afe76a65d43639.mp4\",\"416b7febdc241f5153b30d512b176a89.mp4\",\"432585f8df2828c1e9fc1681d38f71a6.mp4\",\"4328a870-9b2c-4def-978e-1cdae2d6bbfa.mp4\",\"43d49d57-0908-46d6-a272-acd1eeba5726.mp4\",\"4403ec9b49a32b5fa12b36bcb930f25b.mp4\",\"45a03f12-c72d-4605-86f5-25bc569d67fb.mp4\",\"46b7341664dd6e4b0d688ac77515af1b.mp4\",\"479298eb-f354-45f0-923f-8c989e7d4368.mp4\",\"4a4b56b5fe47bb512d2c121b9bcdd58e.mp4\",\"4b0e696e-3336-4dbe-b419-a02cf70f2066.mp4\",\"4d56492c-30cd-4a36-b081-7a958347b053.mp4\",\"4dce5f95a4589e3c46efb33478213981.mp4\",\"4deda99050f3001ecdd300d251e48965.mp4\",\"4eb3ab5e062b3c298eaaf02868ba2089.mp4\",\"4f5a15db36ee772355f6c1187b578396.mp4\",\"50ec779b-e31a-4464-9446-483b83790525.mp4\",\"528a0817c8c2a1d43af1da6cd71da58c.mp4\",\"52a00b708b81b3410f40cc2451e75d3e.mp4\",\"52c426e22262c2ef37883ca543fdaace.mp4\",\"52e87e1b-a4d5-4d73-a358-a3ba51abb7ea.mp4\",\"5460c5ad-c03f-4509-bed3-602d0f46f87a.mp4\",\"55e3e52f-d16c-458c-ba02-7e762ee39507.mp4\",\"561413a5add3d46924ac6ef7752324ea.mp4\",\"56289a282ffdf44c813d1b2a9e81c0ef.mp4\",\"566d0493-6e34-4d25-8413-aea1059db421.mp4\",\"5826150c-02c2-4398-892b-0636169de1dd.mp4\",\"5a0369cd30c0c453a48f42e0f8921c9b.mp4\",\"5d1343e7a458af5550101b368f8d762a.mp4\",\"5d578759-c466-43a1-854e-3770024eeae2.mp4\",\"5df164bf0b7a48157c18eca2daa3c50c.mp4\",\"61ad9f45-3039-4ad7-9b6a-3f83c1785ea1.mp4\",\"6204beff1ba0e07f6406c7f47cbfed2e.mp4\",\"625a0b1a-13f0-4292-9c44-e44b9669c847.mp4\",\"6506457f-0ab4-4ae3-bdcb-5ec69c1acace.mp4\",\"650fed1a-4169-4600-ad47-362a74e25f17.mp4\",\"68756deb-3829-4c1f-8fa2-7a7711a2a3c3.mp4\",\"695c602d77bfef2b45ad9062d8aee76d.mp4\",\"69f516e3b38c9d97450d0ff3c734a316.mp4\",\"6b55f2d4-4c6d-435a-8c99-e64154072e54.mp4\",\"6d050891-f929-447a-85a1-9f93e7425488.mp4\",\"6d2334f1-55db-4513-b3bb-115088e6c844.mp4\",\"6d2e4fbf2b49246288e2a872e34ad2d0.mp4\",\"6d6be2cd07e743ff696901f0d74a9abb.mp4\",\"6f8fd5f0a906098ff0c5b9491c582170.mp4\",\"70430a41-273e-44f3-933b-0b5ff91293e4.mp4\",\"724aba63c6898b42fae22eedd89cceda.mp4\",\"7308a580-d68d-4cf9-9b1b-177cec8e1ece.mp4\",\"74a2be98f4d218093eb2c4103463826b.mp4\",\"74f3aac92d6b5c6a35fb63f25036b58b.mp4\",\"775e4859e0d9a0ec318af387da72e539.mp4\",\"790661587415b1bb6cb08fc20769404f.mp4\",\"7b83788af78979cfa23ec077110ebbca.mp4\",\"7bcd62b4-1a2e-4bb9-b84f-fb25daf81d45.mp4\",\"7d173a01094645cf581ab85b18ebce89.mp4\",\"7d18b533-7f61-48f0-b410-81581405f150.mp4\",\"7d9dc77f-0d89-4545-ac8b-b8747d431f89.mp4\",\"7e52fb8a-4b93-4c6d-9d98-327312cd3285.mp4\",\"7e96304d-3574-451d-b6f8-fe3ea6c2b800.mp4\",\"8146b28e-d7c6-433d-8370-b5ca75f435a8.mp4\",\"81724a537d91bb1d14a7e11452482dc4.mp4\",\"84d3cfaa-4f03-497a-9477-0386d6bdfeaa.mp4\",\"87dc87a8d845e7cdef463d1b53319d35.mp4\",\"881e85aa-93da-452a-a433-2e61577e7bb5.mp4\",\"891286b1-4fdb-45db-b5fe-7d80faacc0f4.mp4\",\"89cc7bfddc76c760db67be8fb87a10f9.mp4\",\"8a4da36e-46d9-445a-89a0-6850bf40abf1.mp4\",\"8b837a17b345411a5579527369b03947.mp4\",\"8cf71e27930386bce8e755d6cffacdba.mp4\",\"8d06b0d87889aeb20ff3216b9eaa1806.mp4\",\"8dc1b4b0307f1130581303a83f0d80bf.mp4\",\"8e01cd5c9af688dde371ee5d04b87dc1.mp4\",\"8e76804b-9ce5-4f56-9153-7a57b13fe803.mp4\",\"8f8494b8-70c4-4566-8152-71018a15a2ab.mp4\",\"92646921e4ca9fae5ea6db0cc509b7d2.mp4\",\"935febb45079017c4dc75f5eeb8f6518.mp4\",\"942632167f9119eccb68ca425a057727.mp4\",\"95a225ebc5cd0a2ff1a2411f84196f14.mp4\",\"9b2b834cd8b04c22bb43372a0ffe903a.mp4\",\"9cef0d32-72bf-4f5c-94b5-31b5adad421d.mp4\",\"9d43ac14-02ed-4dfa-a448-1a4f926250a1.mp4\",\"9eec6a69ce25d31136025bdd1c540080.mp4\",\"9f7ceb6c37e5a039bd2c6d0e26cb6022.mp4\",\"9f925694-58cf-4da3-8d76-95bc5922d093.mp4\",\"9fb5cf41-d7e2-43ac-935b-d6e65088673b.mp4\",\"a0e25270-4e12-46c0-bf75-3ab4fed8a373.mp4\",\"a21a0632-72c8-4549-9098-0405fa0dd1ad.mp4\",\"a2733f15-5ec5-4e54-b62a-8ae689033e05.mp4\",\"a2b1b221-523c-48ed-bc1c-7e4183bf1ba6.mp4\",\"a3a986bf4dc13f658c5d1d7a93b6c297.mp4\",\"a3bc8c26-61fe-4e34-8c9e-2241a76b1d96.mp4\",\"a463674054af84f5fbe84cf1e67c3ae8.mp4\",\"a47bbd60-c945-4108-9838-7ca0fc38293e.mp4\",\"a49ae5c002e5332dbef832ebf6ce17d0.mp4\",\"a4aa2c3095033bec47e318bee4ecac64.mp4\",\"a9c08de4-eb84-416f-b2eb-05bb9bbeddb1.mp4\",\"aa8e8c5942d7da1ae4f04db9aa6b3250.mp4\",\"ab3ece89-48c8-490c-8271-b6c3e0e7ce72.mp4\",\"ace5d43b6b8c07d638fa7a2b4fdcd5f2.mp4\",\"adc55ad5-40d0-4e0d-bcb5-851cf87be874.mp4\",\"af61efe4082eb9ef594e10dcf42ee335.mp4\",\"b00148dd19a12a5b3ee6c23ea22d0770.mp4\",\"b040c78a-fb0e-4719-879f-95c37be89604.mp4\",\"b093f93b-7d65-4987-a851-5f60399712f5.mp4\",\"b0c0f6cb3b964319c7b4be6aecb98804.mp4\",\"b20ae1ff2485b09131b48934f404974d.mp4\",\"b2c21559b9b2a4be79a36b54f2019afb.mp4\",\"b3129849e85d01923106c532cf7bdd2f.mp4\",\"b4e3c1e5d6018f6f53435245c0c39dde.mp4\",\"b65b51945d879456a43c04bb2c69de80.mp4\",\"b792d628-0cde-4b05-a8ca-866390980301.mp4\",\"b9e5f9df8eceb8b57fcfb70c6a1c570d.mp4\",\"baf078da028c06fa1def11bd67745aa9.mp4\",\"bafb3831-6c5c-4bd5-a647-58f5f5cfeba5.mp4\",\"bbde020cd584bcc0dc9d3496553c3101.mp4\",\"bca57a48-443f-4fca-b585-41eaeb99c6ac.mp4\",\"bcded773-d755-4163-babc-07a0f704289b.mp4\",\"bee26434-ea32-4bb0-acf9-1fe2950e2a71.mp4\",\"bee53501-d73b-474b-b819-f4a17b6196f4.mp4\",\"bf8ce032-1992-4bb1-8ba2-a24cce3f2080.mp4\",\"c04577d031fb39d84972d891a8683b13.mp4\",\"c108a89f1e719fa8e84c5bb97b2e218d.mp4\",\"c1199908-88f6-45f1-b62d-061ae42ae71d.mp4\",\"c1dfe870-a78e-4716-9c26-d2bd95b6ed24.mp4\",\"c277958a-8b6c-437e-a8cb-30352c2c4946.mp4\",\"c4218af3b603ac95962897e97019c5e1.mp4\",\"c5c92aeaae50de042ebdaca3c607dcba.mp4\",\"c72c8e1abc39083d65477bbb3213bdff.mp4\",\"c81e32da-9cbe-4f71-a12f-49d59d77bd42.mp4\",\"c9437b5f33031823dee6869a37d5d6a5.mp4\",\"ca9d3af59e9ca354e3457fbef7b4c9f8.mp4\",\"cb0ec531-65d3-4cc6-b3a3-df731e87525b.mp4\",\"cc19fa0bcea52ce3c469b4f9ce24e0bd.mp4\",\"cc3db010fcbce13679286652dd118332.mp4\",\"ce33b360-a3e9-4bb9-83fa-fa3f49a63ee2.mp4\",\"ced64b0b-7719-4358-929e-e1701b1f3187.mp4\",\"ced71338913984c3da09b9f0ae01593e.mp4\",\"cffcb1df-946b-45f6-8092-922c6d8ee108.mp4\",\"d1d1e355-1177-4092-8426-de2db16a30cb.mp4\",\"d2ad6e84a64b6d76f6cd582b83ebeefd.mp4\",\"d5e8d7eda6d05fe165f37fc81fd85643.mp4\",\"d6e2c928-aef5-4342-9d42-160358842cbb.mp4\",\"d7dd2ea0b954fec3dd4912a97a75ca18.mp4\",\"d7ff7f514a54735bce1b0ed4e8d1a108.mp4\",\"d9234f9f831f9b10d2ae2eb65f5b4922.mp4\",\"d93cf259-0551-4ada-bf16-053742460a80.mp4\",\"d9f0669a00d6a01e4694d25676a4293b.mp4\",\"db7fb393-04ac-4ac9-973d-79570de38371.mp4\",\"de4ad2e146917fe6906e5606bfffb397.mp4\",\"de8e8852673455d3f55ed5addfce7e13.mp4\",\"dec7d2dc-fe9d-48b0-acb2-49ca0de4be80.mp4\",\"e08b79e5611f614c688b41beb3170f34.mp4\",\"e0bb6bee98f1b0a3257886c6944312bd.mp4\",\"e0be7db6899ef8cc40e267d6db83a271.mp4\",\"e33a656f5f4c9b7848cbbacce3d18254.mp4\",\"e38bfc85423f549e7b6a1fdbeb531053.mp4\",\"e39c4cf754168d5b8b10cbaead3e1aa2.mp4\",\"e47cd0c8a2313d6e67e880d6ffaf3a29.mp4\",\"e744378d-4e26-4531-9215-685820d073b7.mp4\",\"e7aac0bfc1565a0734be29c45f8ada42.mp4\",\"ea39c81e-1c5e-4459-8c23-18d3ec923dc2.mp4\",\"eab22bb8-29fd-496e-ae0c-78d43d5fe569.mp4\",\"ecd26ca033c23e11663503ef40951323.mp4\",\"edb9551a6bf78ce5e89f0f4779da517f.mp4\",\"edc4a936dd5583fb3a9d1cfb238898d3.mp4\",\"f1f980e44bde908849ab6839992f918b.mp4\",\"f3ecbd7d633dc4a2ae2b44299346a110.mp4\",\"f41220bca3240ca07af1635ca4c5aa58.mp4\",\"f4c1fa52-3c94-4afd-8cef-8710e25443e7.mp4\",\"f4fbce2d1889cae3692fd3b63a47eaef.mp4\",\"f59e4cef6ad80f4cd78cff9fc4325e95.mp4\",\"f646b5d5b4a280aa0dd06a10b6a439f3.mp4\",\"f6789da7-cfe1-404a-a8aa-96d161c5a420.mp4\",\"f6cd95c4-303e-444f-8f5d-057abea5ba98.mp4\",\"f75cc09b59e910cdbcbf6b7f5fe1540b.mp4\",\"f771be965b645ba9126ec2640cdf30c5.mp4\",\"f7973ea03337e17307c6a0760dc2bf7c.mp4\",\"f7d9ec864069529f5648c46276c6fff2.mp4\",\"f7dca8fd77d3473755185a2a8bda240e.mp4\",\"f8f0dfc9-3f5c-49b0-9112-2344b291800b.mp4\",\"fb57b33c-4025-4873-ac77-313eb8928ecc.mp4\",\"fbc3cfcb-6884-42c9-b19b-378f58b33605.mp4\",\"fd5570d7-77ab-440a-a5b6-faf94dd98725.mp4\",\"fd7f068506f01a0b5fc50059faf9bcea.mp4\",\"fe572d81-84f8-4cf8-ac9a-da1e334109ac.mp4\",\"ff18b8dd-9de9-42c4-9a39-5444424f5aa8.mp4\",\"selenoid0f9dbdef62dbe562e1e2a536e7c9d077.mp4\",\"selenoid321e719c1e4d946050a8521c32c4c2e6.mp4\",\"selenoid61bbe4e905469df0db732fc04cf04199.mp4\",\"selenoid698ea5011005d3710460640c9e5fa247.mp4\",\"selenoid709748b068957c24b07aef66702f43b4.mp4\",\"selenoid7b159ab072f952f5632acc048a8371f2.mp4\",\"selenoid7bc35573eadd7dfae21994579ff09684.mp4\",\"selenoid8a6a64e7f31170fa015fbcd8d8bbce9a.mp4\",\"selenoida0afe186ac6939fa34714b367bf810d0.mp4\",\"selenoida2cf74d6acaca4db30f347f4ae6fc9e0.mp4\",\"selenoide96852497befe0e606f12ba59e1697ec.mp4\",\"selenoidf0aafd941917f42798627374e87fc62f.mp4\",\"selenoidf52baa4579ec5b798348224d1f623f1b.mp4\"]},\"origin\":\"http://62.113.108.218:4444\",\"browsers\":{\"chrome\":0,\"firefox\":0},\"sessions\":{},\"version\":\"1.10.9[2023-01-16_11:07:09AM]\",\"errors\":[]}";
        String actualResponse = given()
                .log().uri()
                .when()
                .get("http://62.113.108.218:8080/status")
                .then()
                .log().status()
                .statusCode(200)
                .extract().response().asString();
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @Tag("api")
    void checkResponseGoodPractice() {
        Integer expectedTotal = 5;
        Integer actualResponse = given()
                .log().uri()
                .when()
                .get("http://62.113.108.218:8080/status")
                .then()
                .log().status()
                .statusCode(200)
                .extract().path("state.total");

        assertEquals(expectedTotal, actualResponse);
    }

    @Test
    @Tag("api")
    void checkJsonScheme() {
        given()
                .log().uri()
                .when()
                .get("http://62.113.108.218:8080/status")
                .then()
                .log().status()
                .statusCode(200)
                .body("state.total", is(5))
                .body("state.browsers.chrome", hasKey("112.0"))
                .body(matchesJsonSchemaInClasspath("schemes/status_scheme-response.json"));
    }

    @Test
    @Tag("api")
    void successfulLoginTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        given()
                .log().uri()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));

        //.body(matchesJsonSchemaInClasspath("schemes/status_scheme-response.json"));
    }

    @Test
    @Tag("api")
    void unsuccessfulLoginWithMissingEmailTest() {
        String body = "{ \"password\": \"cityslicka\" }";

        given()
                .log().uri()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));

        //.body(matchesJsonSchemaInClasspath("schemes/status_scheme-response.json"));
    }

    @Test
    @Tag("api")
    void unsuccessfulLoginWithMissingPasswordTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\" }";

        given()
                .log().uri()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));

        //.body(matchesJsonSchemaInClasspath("schemes/status_scheme-response.json"));
    }

    @Test
    @Tag("api")
    void unsuccessfulLoginWithEmptyDataTest() {
        String body = "";

        given()
                .log().uri()
//                .body(body)
//                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(415);
    }

}