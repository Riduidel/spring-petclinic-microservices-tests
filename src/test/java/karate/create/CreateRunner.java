package karate.create;

import com.intuit.karate.junit5.Karate;

class CreateRunner {
    
    @Karate.Test
    Karate customers() {
        return Karate.run("customers").relativeTo(getClass());
    }    
    
    @Karate.Test
    Karate pets() {
        return Karate.run("pets").relativeTo(getClass());
    }    

}
