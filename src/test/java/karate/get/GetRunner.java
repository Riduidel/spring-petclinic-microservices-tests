package karate.get;

import com.intuit.karate.junit5.Karate;

class GetRunner {
    
    @Karate.Test
    Karate getVets() {
        return Karate.run("vets").relativeTo(getClass());
    }    
    
    @Karate.Test
    Karate getCustomers() {
        return Karate.run("customers").relativeTo(getClass());
    }    

}
