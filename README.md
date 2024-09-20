# Midterm exam Project 🚀

This Spring Boot Application contains five end points :

    /validate/email
    /parse/name

### How to use the end points

#### /validate/email

    /validate/email?email=<username@domain.com>
        
        This end point validates if the supplied value for email address is valid.
        This will aid in validating if form inputs are erroneous.
        Better be careful, please supply the correct email addresses next time.
        One might get lucky with Amazon gift cards
        
    sample output : 
    
    /validate/email?email=chancellor.galiza@upd.edu.ph

    reponse : true

#### /parse/name
    
    /parse/name?name=Chancellor Galiza
        
        This end point will parse the firstname and lastname from the supplied String.
        This will be helpfull if you forgot your name. Chancellor is my name, it is
        considered as a high ranking official in Germany and Universities
        
    sample output : 
    
    /parse/name?name=Chancellor Galiza

    reponse : 
    
    {
        "firstName": "Chancellor",
        "lastName": "Galiza"
    }
    
    /parse/name?name=Dr. Chancellor
    
    response :
    {
        "name": "Dr. Chancellor",
        "error": "supplied name can't be parsed"
    }
    
    Note: unless you name is Dr. the output is wrong. please send me an email to
    chancellor.galiza@upd.edu.ph, I will make amends.
    


    
#### Thanks

    Hope you all enjoy the codes as much I enjoy writing them
    
                                        - Chancellor Galiza
    
## The used key  is always bright.
