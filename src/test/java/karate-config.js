function fn() {
  var env = karate.env; // get system property 'karate.env'
//  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }
  var config = {
    env: env,
    petclinic: 'http://localhost:8080'
  }
  if(karate.properties['url']!=null) {
  	config.petclinic = karate.properties['url'] 
  }
  config.faker = Java.type('com.github.javafaker.Faker');
  return config;
}