Example of PowerMock with mockito-core instead of mockito-all.

Problems (see pom.xml):

a) If JUnit is an explicit dependency BEFORE powermock-api-mockito,
   JUnit's Hamcrest 1.3 dependency wins and test runs fine.

b) If JUnit is an explicit dependency AFTER powermock-api-mockito,
   powermock-api-mockito's Hamcrest 1.1 dependency wins and test fails.

c) If JUnit is not an explicit dependency but a transient dependency of powermock-module-junit4,
   powermock-api-mockito's Hamcrest 1.1 dependency wins and test fails.

d) If Hamcrest 1.3 is an explicit dependency,
   it wins and test runs fine.

The wording "test fails" means java.lang.NoClassDefFoundError: org/hamcrest/MatcherAssert due to assertThat()
