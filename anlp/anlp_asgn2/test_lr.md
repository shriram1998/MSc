> Reading training data from data\training_data.json...
> Reading validation data from data/test_data.json...
> Tokenising and annotating raw data with spacy...
> Training logistic_regression model on training data...
> Finished training logistic regression on 7348 tokens
> Predicting tags on validation data...
> Evaluating results on validation data...
Input: we will arrive tomorrow at 25 to 7 p.m.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   we              O               O                 Y                arrive         we             PRP     nsubj   
1   will            O               O                 Y                arrive         will           MD      aux     
2   arrive          O               O                 Y                arrive         arrive         VB      ROOT    
3   tomorrow        B-date_from     B-date               N    DATE     arrive         tomorrow       NN      npadvmod
4   at              O               O                 Y                arrive         at             IN      prep    
5   25              B-time_from     B-time               N    TIME     7              25             CD      quantmod
6   to              I-time_from     I-time               N    TIME     7              to             TO      quantmod
7   7               I-time_from     B-date_to            N    TIME     at             7              CD      pobj    
8   p.m.            I-time_from     O                    N    TIME     arrive         p.m.           NN      npadvmod

annotated spans:
  (3, 4): date_from      
  (5, 9): time_from      

predicted spans:
  (3, 4): date
  (5, 7): time
  (7, 8): date_to

=============================================================================================

Input: why don't you offer massages anymore?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   why             O               O                 Y                offer          why            WRB     advmod  
1   do              O               O                 Y                offer          do             VBP     aux     
2   n't             O               O                 Y                offer          n't            RB      neg     
3   you             O               O                 Y                offer          you            PRP     nsubj   
4   offer           O               O                 Y                offer          offer          VB      ROOT    
5   massages        O               O                 Y                offer          massage        NNS     dobj    
6   anymore         O               O                 Y                offer          anymore        RB      advmod  
7   ?               O               O                 Y                offer          ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: how do i cancel my restaurant booking of the 20th of April

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   how             O               O                 Y                cancel         how            WRB     advmod  
1   do              O               O                 Y                cancel         do             VBP     aux     
2   i               O               O                 Y                cancel         I              PRP     nsubj   
3   cancel          O               O                 Y                cancel         cancel         VB      ROOT    
4   my              O               O                 Y                booking        my             PRP$    poss    
5   restaurant      O               O                 Y                booking        restaurant     NN      compound
6   booking         O               O                 Y                cancel         booking        NN      dobj    
7   of              O               O                 Y                booking        of             IN      prep    
8   the             O               O                 Y       DATE     20th           the            DT      det     
9   20th            B-date          B-date_from          N    DATE     of             20th           NN      pobj    
10  of              I-date          O                    N    DATE     20th           of             IN      prep    
11  April           I-date          B-date_from          N    DATE     of             April          NNP     pobj    

annotated spans:
  (9, 12): date           

predicted spans:
  (9, 10): date_from
  (11, 12): date_from

=============================================================================================

Input: any constraints on the number of nights we can stay during the Christmas time?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   any             O               O                 Y                constraints    any            DT      det     
1   constraints     O               O                 Y                constraints    constraint     NNS     ROOT    
2   on              O               O                 Y                constraints    on             IN      prep    
3   the             O               O                 Y                number         the            DT      det     
4   number          O               O                 Y                on             number         NN      pobj    
5   of              O               O                 Y                number         of             IN      prep    
6   nights          O               O                 Y                of             night          NNS     pobj    
7   we              O               O                 Y                stay           we             PRP     nsubj   
8   can             O               O                 Y                stay           can            MD      aux     
9   stay            O               O                 Y                constraints    stay           VB      relcl   
10  during          O               O                 Y                stay           during         IN      prep    
11  the             O               B-rooms              N             time           the            DT      det     
12  Christmas       O               O                 Y       DATE     time           Christmas      NNP     compound
13  time            O               O                 Y                during         time           NN      pobj    
14  ?               O               O                 Y                stay           ?              .       punct   

annotated spans:

predicted spans:
  (11, 12): rooms

=============================================================================================

Input: got it, then just rebook me to another hotel

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   got             O               O                 Y                rebook         get            VBD     advcl   
1   it              O               O                 Y                got            it             PRP     dobj    
2   ,               O               O                 Y                rebook         ,              ,       punct   
3   then            O               O                 Y                rebook         then           RB      advmod  
4   just            O               O                 Y                rebook         just           RB      advmod  
5   rebook          O               O                 Y                rebook         rebook         VBD     ROOT    
6   me              O               O                 Y                rebook         I              PRP     dobj    
7   to              O               O                 Y                rebook         to             IN      prep    
8   another         O               O                 Y                hotel          another        DT      det     
9   hotel           O               O                 Y                to             hotel          NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: Laters

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Laters          O               O                 Y                Laters         later          NNS     ROOT    

annotated spans:

predicted spans:

=============================================================================================

Input: Hi, can I get some food delivered now

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Hi              O               O                 Y                get            Hi             NNP     intj    
1   ,               O               O                 Y                Hi             ,              ,       punct   
2   can             O               O                 Y                get            can            MD      aux     
3   I               O               O                 Y                get            I              PRP     nsubj   
4   get             O               O                 Y                get            get            VB      ROOT    
5   some            O               O                 Y                food           some           DT      det     
6   food            O               O                 Y                get            food           NN      dobj    
7   delivered       O               O                 Y                food           deliver        VBN     acl     
8   now             O               O                 Y                delivered      now            RB      advmod  

annotated spans:

predicted spans:

=============================================================================================

Input: Speak to someone about room service

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Speak           O               O                 Y                Speak          speak          VB      ROOT    
1   to              O               O                 Y                Speak          to             IN      prep    
2   someone         O               O                 Y                to             someone        NN      pobj    
3   about           O               O                 Y                someone        about          IN      prep    
4   room            O               O                 Y                service        room           NN      compound
5   service         O               O                 Y                about          service        NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I'd like to change my current booking to a smaller and cheaper room if possible.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   'd              O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   to              O               O                 Y                change         to             TO      aux     
4   change          O               O                 Y                like           change         VB      xcomp   
5   my              O               O                 Y                booking        my             PRP$    poss    
6   current         O               O                 Y                booking        current        JJ      amod    
7   booking         O               O                 Y                change         booking        NN      dobj    
8   to              O               O                 Y                change         to             IN      prep    
9   a               O               O                 Y                room           a              DT      det     
10  smaller         O               O                 Y                room           small          JJR     amod    
11  and             O               O                 Y                smaller        and            CC      cc      
12  cheaper         O               O                 Y                smaller        cheap          JJR     conj    
13  room            O               O                 Y                to             room           NN      pobj    
14  if              O               O                 Y                possible       if             IN      mark    
15  possible        O               O                 Y                change         possible       JJ      advcl   
16  .               O               O                 Y                like           .              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: what is the check in time in your hotel

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   what            O               O                 Y                is             what           WP      attr    
1   is              O               O                 Y                is             be             VBZ     ROOT    
2   the             O               O                 Y                check          the            DT      det     
3   check           O               O                 Y                is             check          NN      nsubj   
4   in              O               O                 Y                check          in             IN      prep    
5   time            O               O                 Y                in             time           NN      pobj    
6   in              O               O                 Y                time           in             IN      prep    
7   your            O               O                 Y                hotel          your           PRP$    poss    
8   hotel           O               O                 Y                in             hotel          NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: i slept in and will have to check out later than 6

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y                slept          I              PRP     nsubj   
1   slept           O               O                 Y                slept          sleep          VBD     ROOT    
2   in              O               O                 Y                slept          in             IN      prt     
3   and             O               O                 Y                slept          and            CC      cc      
4   will            O               O                 Y                have           will           MD      aux     
5   have            O               O                 Y                slept          have           VB      conj    
6   to              O               O                 Y                check          to             TO      aux     
7   check           O               O                 Y                have           check          VB      xcomp   
8   out             O               O                 Y                check          out            RP      prt     
9   later           O               O                 Y       CARDINAL 6              later          RB      advmod  
10  than            O               O                 Y       CARDINAL 6              than           IN      quantmod
11  6               B-time          B-number             N    CARDINAL slept          6              CD      npadvmod

annotated spans:
  (11, 12): time           

predicted spans:
  (11, 12): number

=============================================================================================

Input: put more people under the reservation rickelle kawamoto

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   put             O               O                 Y                put            put            VB      ROOT    
1   more            O               O                 Y                people         more           JJR     amod    
2   people          O               O                 Y                put            people         NNS     dobj    
3   under           O               O                 Y                put            under          IN      prep    
4   the             O               O                 Y                kawamoto       the            DT      det     
5   reservation     O               O                 Y                rickelle       reservation    NN      compound
6   rickelle        B-person_name   O                    N             kawamoto       rickelle       NN      compound
7   kawamoto        I-person_name   O                    N             under          kawamoto       NN      pobj    

annotated spans:
  (6, 8): person_name    

predicted spans:

=============================================================================================

Input: Sounds good yeah!

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Sounds          O               O                 Y                Sounds         sound          VBZ     ROOT    
1   good            O               O                 Y                Sounds         good           JJ      acomp   
2   yeah            O               O                 Y                Sounds         yeah           UH      intj    
3   !               O               O                 Y                Sounds         !              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I wanna open another reservation

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                wanna          I              PRP     nsubj   
1   wanna           O               O                 Y                wanna          wanna          VBP     ROOT    
2   open            O               O                 Y                wanna          open           VB      ccomp   
3   another         O               O                 Y                reservation    another        DT      det     
4   reservation     O               O                 Y                open           reservation    NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: Is it allowed to bring your dog to the pool?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Is              O               O                 Y                allowed        be             VBZ     auxpass 
1   it              O               O                 Y                allowed        it             PRP     nsubjpass
2   allowed         O               O                 Y                allowed        allow          VBN     ROOT    
3   to              O               O                 Y                bring          to             TO      aux     
4   bring           O               O                 Y                allowed        bring          VB      xcomp   
5   your            O               O                 Y                dog            your           PRP$    poss    
6   dog             O               O                 Y                bring          dog            NN      dobj    
7   to              O               O                 Y                bring          to             IN      prep    
8   the             O               O                 Y                pool           the            DT      det     
9   pool            O               O                 Y                to             pool           NN      pobj    
10  ?               O               O                 Y                allowed        ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: no, I'm talking about an existing one, made 3 days ago

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   no              O               O                 Y                talking        no             UH      intj    
1   ,               O               O                 Y                talking        ,              ,       punct   
2   I               O               O                 Y                talking        I              PRP     nsubj   
3   'm              O               O                 Y                talking        be             VBP     aux     
4   talking         O               O                 Y                talking        talk           VBG     ROOT    
5   about           O               O                 Y                talking        about          IN      prep    
6   an              O               O                 Y                one            an             DT      det     
7   existing        O               O                 Y                one            exist          VBG     amod    
8   one             O               O                 Y                about          one            NN      pobj    
9   ,               O               O                 Y                one            ,              ,       punct   
10  made            O               O                 Y                one            make           VBD     acl     
11  3               B-date          B-date_period        N    DATE     days           3              CD      nummod  
12  days            I-date          O                    N    DATE     ago            day            NNS     npadvmod
13  ago             I-date          O                    N    DATE     made           ago            RB      advmod  

annotated spans:
  (11, 14): date           

predicted spans:
  (11, 12): date_period

=============================================================================================

Input: wifi is broken

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   wifi            O               O                 Y                broken         wifi           NN      nsubjpass
1   is              O               O                 Y                broken         be             VBZ     auxpass 
2   broken          O               O                 Y                broken         break          VBN     ROOT    

annotated spans:

predicted spans:

=============================================================================================

Input: A room with toilet.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   A               B-rooms         B-rooms           Y                room           a              DT      det     
1   room            I-rooms         I-rooms           Y                room           room           NN      ROOT    
2   with            O               O                 Y                room           with           IN      prep    
3   toilet          O               O                 Y                with           toilet         NN      pobj    
4   .               O               O                 Y                room           .              .       punct   

annotated spans:
Y (0, 2): rooms          

predicted spans:
Y (0, 2): rooms

=============================================================================================

Input: Is there a gym

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Is              O               O                 Y                Is             be             VBZ     ROOT    
1   there           O               O                 Y                Is             there          EX      expl    
2   a               O               O                 Y                gym            a              DT      det     
3   gym             O               O                 Y                Is             gym            NN      attr    

annotated spans:

predicted spans:

=============================================================================================

Input: what is the cost of the spa

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   what            O               O                 Y                is             what           WP      attr    
1   is              O               O                 Y                is             be             VBZ     ROOT    
2   the             O               O                 Y                cost           the            DT      det     
3   cost            O               O                 Y                is             cost           NN      nsubj   
4   of              O               O                 Y                cost           of             IN      prep    
5   the             O               O                 Y                spa            the            DT      det     
6   spa             O               O                 Y                of             spa            NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: 3

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   3               B-number        B-number          Y       CARDINAL 3              3              LS      ROOT    

annotated spans:
Y (0, 1): number         

predicted spans:
Y (0, 1): number

=============================================================================================

Input: i think i dropped my phone

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y                think          I              PRP     nsubj   
1   think           O               O                 Y                think          think          VBP     ROOT    
2   i               O               O                 Y                dropped        I              PRP     nsubj   
3   dropped         O               O                 Y                think          drop           VBD     ccomp   
4   my              O               O                 Y                phone          my             PRP$    poss    
5   phone           O               O                 Y                dropped        phone          NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: i want to park my car somewhere

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                park           to             TO      aux     
3   park            O               O                 Y                want           park           VB      xcomp   
4   my              O               O                 Y                car            my             PRP$    poss    
5   car             O               O                 Y                park           car            NN      dobj    
6   somewhere       O               O                 Y                park           somewhere      RB      advmod  

annotated spans:

predicted spans:

=============================================================================================

Input: I want to come tonight

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                come           to             TO      aux     
3   come            O               O                 Y                want           come           VB      xcomp   
4   tonight         O               O                 Y       TIME     come           tonight        NN      npadvmod

annotated spans:

predicted spans:

=============================================================================================

Input: Could you please cancel the lunch booking for 4 at 11:45 am under shanta ricciardi?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Could           O               O                 Y                cancel         could          MD      aux     
1   you             O               O                 Y                cancel         you            PRP     nsubj   
2   please          O               O                 Y                cancel         please         UH      intj    
3   cancel          O               O                 Y                cancel         cancel         VB      ROOT    
4   the             O               O                 Y                booking        the            DT      det     
5   lunch           O               O                 Y                booking        lunch          NN      compound
6   booking         O               O                 Y                cancel         booking        NN      dobj    
7   for             O               O                 Y                cancel         for            IN      prep    
8   4               B-people        B-people          Y       CARDINAL for            4              CD      pobj    
9   at              O               O                 Y                4              at             IN      prep    
10  11:45           B-time          B-time            Y       TIME     am             11:45          CD      nummod  
11  am              I-time          I-time            Y       TIME     at             am             NN      pobj    
12  under           O               O                 Y                am             under          IN      prep    
13  shanta          B-person_name   B-person_name     Y                ricciardi      shanta         NNP     compound
14  ricciardi       I-person_name   I-person_name     Y                under          ricciardi      NNP     pobj    
15  ?               O               O                 Y                cancel         ?              .       punct   

annotated spans:
Y (8, 9): people         
Y (10, 12): time           
Y (13, 15): person_name    

predicted spans:
Y (8, 9): people
Y (10, 12): time
Y (13, 15): person_name

=============================================================================================

Input: change hotel booking, my name is edens

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   change          O               O                 Y                is             change         VB      advcl   
1   hotel           O               O                 Y                booking        hotel          NN      compound
2   booking         O               O                 Y                change         booking        NN      dobj    
3   ,               O               O                 Y                is             ,              ,       punct   
4   my              O               O                 Y                name           my             PRP$    poss    
5   name            O               O                 Y                is             name           NN      nsubj   
6   is              O               O                 Y                is             be             VBZ     ROOT    
7   edens           B-person_name   O                    N             is             eden           NNS     attr    

annotated spans:
  (7, 8): person_name    

predicted spans:

=============================================================================================

Input: can I get an acupuncture session for the 17 Sep at 11 00 in the morning

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   can             O               O                 Y                get            can            MD      aux     
1   I               O               O                 Y                get            I              PRP     nsubj   
2   get             O               O                 Y                get            get            VB      ROOT    
3   an              O               O                 Y                session        an             DT      det     
4   acupuncture     O               O                 Y                session        acupuncture    NN      compound
5   session         O               O                 Y                get            session        NN      dobj    
6   for             O               O                 Y                session        for            IN      prep    
7   the             O               O                 Y                Sep            the            DT      det     
8   17              B-date          B-date_from          N             Sep            17             CD      nummod  
9   Sep             I-date          I-date_from          N             for            Sep            NNP     pobj    
10  at              O               O                 Y                get            at             IN      prep    
11  11              B-time          B-time            Y       DATE     00             11             CD      nummod  
12  00              I-time          I-time            Y       DATE     at             00             CD      pobj    
13  in              I-time          O                    N             get            in             IN      prep    
14  the             I-time          O                    N             morning        the            DT      det     
15  morning         I-time          B-time_period        N    TIME     in             morning        NN      pobj    

annotated spans:
  (8, 10): date           
  (11, 16): time           

predicted spans:
  (8, 10): date_from
  (11, 13): time
  (15, 16): time_period

=============================================================================================

Input: what are the restaurant dinner opening hours?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   what            O               O                 Y                are            what           WP      attr    
1   are             O               O                 Y                are            be             VBP     ROOT    
2   the             O               O                 Y                hours          the            DT      det     
3   restaurant      O               O                 Y                dinner         restaurant     NN      compound
4   dinner          O               O                 Y                hours          dinner         NN      compound
5   opening         O               O                 Y       TIME     hours          open           VBG     compound
6   hours           O               O                 Y       TIME     are            hour           NNS     nsubj   
7   ?               O               O                 Y                are            ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I want to order breakfast omelette room service

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                order          to             TO      aux     
3   order           O               O                 Y                want           order          VB      xcomp   
4   breakfast       O               O                 Y                room           breakfast      NN      compound
5   omelette        O               O                 Y                room           omelette       NN      compound
6   room            O               O                 Y                service        room           NN      compound
7   service         O               O                 Y                order          service        NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: Can I change the start date and duration of a reservation i made the other day

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Can             O               O                 Y                change         can            MD      aux     
1   I               O               O                 Y                change         I              PRP     nsubj   
2   change          O               O                 Y                change         change         VB      ROOT    
3   the             O               O                 Y                date           the            DT      det     
4   start           O               O                 Y                date           start          NN      compound
5   date            O               O                 Y                change         date           NN      dobj    
6   and             O               O                 Y                date           and            CC      cc      
7   duration        O               O                 Y                date           duration       NN      conj    
8   of              O               O                 Y                date           of             IN      prep    
9   a               O               O                 Y                reservation    a              DT      det     
10  reservation     O               O                 Y                of             reservation    NN      pobj    
11  i               O               O                 Y                made           I              PRP     nsubj   
12  made            O               O                 Y                reservation    make           VBD     relcl   
13  the             O               O                 Y       DATE     day            the            DT      det     
14  other           O               O                 Y       DATE     day            other          JJ      amod    
15  day             O               O                 Y       DATE     change         day            NN      npadvmod

annotated spans:

predicted spans:

=============================================================================================

Input: a table booking for 2 people on the date 1st of Jan and the time 15 to 2 night

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   a               O               O                 Y                booking        a              DT      det     
1   table           O               O                 Y                booking        table          NN      compound
2   booking         O               O                 Y                booking        booking        NN      ROOT    
3   for             O               O                 Y                booking        for            IN      prep    
4   2               B-people        B-people          Y       CARDINAL people         2              CD      nummod  
5   people          O               O                 Y                for            people         NNS     pobj    
6   on              O               O                 Y                people         on             IN      prep    
7   the             O               O                 Y       DATE     date           the            DT      det     
8   date            O               O                 Y       DATE     on             date           NN      pobj    
9   1st             B-date          B-date_from          N    DATE     booking        1st            NN      npadvmod
10  of              I-date          O                    N    DATE     1st            of             IN      prep    
11  Jan             I-date          O                    N    DATE     of             Jan            NNP     pobj    
12  and             O               O                 Y                1st            and            CC      cc      
13  the             O               B-date_period        N             time           the            DT      det     
14  time            O               O                 Y                1st            time           NN      conj    
15  15              B-time          B-time            Y       TIME     2              15             CD      quantmod
16  to              I-time          O                    N    TIME     2              to             TO      quantmod
17  2               I-time          B-date_to            N    TIME     night          2              CD      nummod  
18  night           I-time          B-time_period        N    TIME     time           night          NN      npadvmod

annotated spans:
Y (4, 5): people         
  (9, 12): date           
  (15, 19): time           

predicted spans:
Y (4, 5): people
  (9, 10): date_from
  (13, 14): date_period
  (15, 16): time
  (17, 18): date_to
  (18, 19): time_period

=============================================================================================

Input: I just want to change the number of guests

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   just            O               O                 Y                want           just           RB      advmod  
2   want            O               O                 Y                want           want           VBP     ROOT    
3   to              O               O                 Y                change         to             TO      aux     
4   change          O               O                 Y                want           change         VB      xcomp   
5   the             O               O                 Y                number         the            DT      det     
6   number          O               O                 Y                change         number         NN      dobj    
7   of              O               O                 Y                number         of             IN      prep    
8   guests          O               O                 Y                of             guest          NNS     pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: Have you got any availability between 17th May to 21st May, we are three for a four night stay

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Have            O               O                 Y                got            have           VBP     aux     
1   you             O               O                 Y                got            you            PRP     nsubj   
2   got             O               O                 Y                are            get            VBN     advcl   
3   any             O               O                 Y                availability   any            DT      det     
4   availability    O               O                 Y                got            availability   NN      dobj    
5   between         O               O                 Y       DATE     availability   between        IN      prep    
6   17th            B-date_from     O                    N    DATE     May            17th           JJ      amod    
7   May             I-date_from     B-date_from          N    DATE     between        May            NNP     pobj    
8   to              O               O                 Y       DATE     got            to             TO      prep    
9   21st            B-date_to       B-date_to         Y       DATE     May            21st           NN      compound
10  May             I-date_to       I-date_to         Y       DATE     to             May            NNP     pobj    
11  ,               O               O                 Y                are            ,              ,       punct   
12  we              O               O                 Y                are            we             PRP     nsubj   
13  are             O               O                 Y                are            be             VBP     ROOT    
14  three           B-people        B-people          Y       CARDINAL are            three          CD      attr    
15  for             O               O                 Y                three          for            IN      prep    
16  a               O               O                 Y                stay           a              DT      det     
17  four            B-date_period   B-date_period     Y       TIME     night          four           CD      nummod  
18  night           I-date_period   I-date_period     Y       TIME     stay           night          NN      compound
19  stay            O               O                 Y                for            stay           NN      pobj    

annotated spans:
  (6, 8): date_from      
Y (9, 11): date_to        
Y (14, 15): people         
Y (17, 19): date_period    

predicted spans:
  (7, 8): date_from
Y (9, 11): date_to
Y (14, 15): people
Y (17, 19): date_period

=============================================================================================

Input: Independence Day

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Independence    B-date          O                    N    EVENT    Day            Independence   NNP     compound
1   Day             I-date          O                    N    EVENT    Day            Day            NNP     ROOT    

annotated spans:
  (0, 2): date           

predicted spans:

=============================================================================================

Input: Thursday 30th June

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Thursday        B-date          B-date            Y       DATE     June           Thursday       NNP     compound
1   30th            I-date          B-date               N    DATE     June           30th           NN      compound
2   June            I-date          I-date            Y       DATE     June           June           NNP     ROOT    

annotated spans:
  (0, 3): date           

predicted spans:
  (0, 1): date
  (1, 3): date

=============================================================================================

Input: 4 single rooms from the 23rd until the 29 May

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   4               B-rooms         B-adults             N    CARDINAL rooms          4              CD      nummod  
1   single          O               O                 Y                rooms          single         JJ      amod    
2   rooms           O               O                 Y                rooms          room           NNS     ROOT    
3   from            O               O                 Y                rooms          from           IN      prep    
4   the             O               O                 Y       DATE     23rd           the            DT      det     
5   23rd            B-date_from     B-date_to            N    DATE     from           23rd           NN      pobj    
6   until           O               O                 Y                rooms          until          IN      prep    
7   the             O               O                 Y                May            the            DT      det     
8   29              B-date_to       B-kids               N             May            29             CD      nummod  
9   May             I-date_to       O                    N             until          May            NNP     pobj    

annotated spans:
  (0, 1): rooms          
  (5, 6): date_from      
  (8, 10): date_to        

predicted spans:
  (0, 1): adults
  (5, 6): date_to
  (8, 9): kids

=============================================================================================

Input: my wife and I will need a room and then another for our teenage daughter

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   my              B-adults        B-adults          Y                wife           my             PRP$    poss    
1   wife            I-adults        I-adults          Y                need           wife           NN      nsubj   
2   and             I-adults        I-adults          Y                wife           and            CC      cc      
3   I               I-adults        O                    N             wife           I              PRP     conj    
4   will            O               O                 Y                need           will           MD      aux     
5   need            O               O                 Y                need           need           VB      ROOT    
6   a               B-rooms         B-rooms           Y                room           a              DT      det     
7   room            I-rooms         O                    N             need           room           NN      dobj    
8   and             I-rooms         O                    N             need           and            CC      cc      
9   then            I-rooms         O                    N             another        then           RB      advmod  
10  another         I-rooms         O                    N             need           another        DT      conj    
11  for             O               O                 Y                another        for            IN      prep    
12  our             O               B-kids               N             daughter       our            PRP$    poss    
13  teenage         O               O                 Y                daughter       teenage        JJ      amod    
14  daughter        B-kids          O                    N             for            daughter       NN      pobj    

annotated spans:
  (0, 4): adults         
  (6, 11): rooms          
  (14, 15): kids           

predicted spans:
  (0, 3): adults
  (6, 7): rooms
  (12, 13): kids

=============================================================================================

Input: I need to book for 4 rooms

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                need           I              PRP     nsubj   
1   need            O               O                 Y                need           need           VBP     ROOT    
2   to              O               O                 Y                book           to             TO      aux     
3   book            O               O                 Y                need           book           VB      xcomp   
4   for             O               O                 Y                book           for            IN      prep    
5   4               B-rooms         B-adults             N    CARDINAL rooms          4              CD      nummod  
6   rooms           O               O                 Y                for            room           NNS     pobj    

annotated spans:
  (5, 6): rooms          

predicted spans:
  (5, 6): adults

=============================================================================================

Input: book for tomorrow

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   book            O               O                 Y                book           book           NN      ROOT    
1   for             O               O                 Y                book           for            IN      prep    
2   tomorrow        B-date_from     B-date               N    DATE     for            tomorrow       NN      pobj    

annotated spans:
  (2, 3): date_from      

predicted spans:
  (2, 3): date

=============================================================================================

Input: 10th to 23rd - 13 nights 14 days - 5 adults 6 children

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   10th            B-date_from     B-date_from       Y       DATE     10th           10th           JJ      ROOT    
1   to              O               O                 Y       DATE     10th           to             IN      prep    
2   23rd            B-date_to       B-date_to         Y       DATE     13             23rd           CD      quantmod
3   -               O               O                 Y       DATE     13             -              SYM     punct   
4   13              B-date_period   B-date_period     Y       DATE     nights         13             CD      nummod  
5   nights          I-date_period   I-date_period     Y                to             night          NNS     pobj    
6   14              I-date_period   B-date               N    DATE     days           14             CD      nummod  
7   days            I-date_period   O                    N    DATE     nights         day            NNS     appos   
8   -               O               O                 Y       DATE     5              -              HYPH    punct   
9   5               B-adults        B-adults          Y       DATE     adults         5              CD      nummod  
10  adults          O               O                 Y                nights         adult          NNS     appos   
11  6               B-kids          B-kids            Y       CARDINAL children       6              CD      nummod  
12  children        O               O                 Y                nights         child          NNS     appos   

annotated spans:
Y (0, 1): date_from      
Y (2, 3): date_to        
  (4, 8): date_period    
Y (9, 10): adults         
Y (11, 12): kids           

predicted spans:
Y (0, 1): date_from
Y (2, 3): date_to
  (4, 6): date_period
  (6, 7): date
Y (9, 10): adults
Y (11, 12): kids

=============================================================================================

Input: arriving tomorrow and leaving after 3 days

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   arriving        O               O                 Y                arriving       arrive         VBG     ROOT    
1   tomorrow        B-date_from     B-date_from       Y       DATE     arriving       tomorrow       NN      npadvmod
2   and             O               O                 Y                arriving       and            CC      cc      
3   leaving         O               O                 Y                arriving       leave          VBG     conj    
4   after           O               O                 Y                leaving        after          IN      prep    
5   3               B-date_period   B-date_period     Y       DATE     days           3              CD      nummod  
6   days            I-date_period   I-date_period     Y       DATE     after          day            NNS     pobj    

annotated spans:
Y (1, 2): date_from      
Y (5, 7): date_period    

predicted spans:
Y (1, 2): date_from
Y (5, 7): date_period

=============================================================================================

Input: 6 kids

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   6               B-kids          B-people             N    CARDINAL kids           6              CD      nummod  
1   kids            O               O                 Y                kids           kid            NNS     ROOT    

annotated spans:
  (0, 1): kids           

predicted spans:
  (0, 1): people

=============================================================================================

Input: me, my wife and the little one

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   me              B-adults        B-adults          Y                me             I              PRP     ROOT    
1   ,               I-adults        O                    N             me             ,              ,       punct   
2   my              I-adults        O                    N             wife           my             PRP$    poss    
3   wife            I-adults        O                    N             me             wife           NN      appos   
4   and             O               O                 Y                wife           and            CC      cc      
5   the             B-kids          O                    N             one            the            DT      det     
6   little          I-kids          O                    N             one            little         JJ      amod    
7   one             I-kids          O                    N             wife           one            CD      conj    

annotated spans:
  (0, 4): adults         
  (5, 8): kids           

predicted spans:
  (0, 1): adults

=============================================================================================

Input: 8 adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   8               B-adults        B-adults          Y       CARDINAL adults         8              CD      nummod  
1   adults          O               O                 Y                adults         adult          NNS     ROOT    

annotated spans:
Y (0, 1): adults         

predicted spans:
Y (0, 1): adults

=============================================================================================

Input: I would like to stay a Thursday to Friday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   would           O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   to              O               O                 Y                stay           to             TO      aux     
4   stay            O               O                 Y                like           stay           VB      xcomp   
5   a               O               O                 Y                Thursday       a              DT      det     
6   Thursday        B-date_from     B-date_from       Y       DATE     stay           Thursday       NNP     npadvmod
7   to              O               O                 Y       DATE     stay           to             IN      prep    
8   Friday          B-date_to       B-date_to         Y       DATE     to             Friday         NNP     pobj    

annotated spans:
Y (6, 7): date_from      
Y (8, 9): date_to        

predicted spans:
Y (6, 7): date_from
Y (8, 9): date_to

=============================================================================================

Input: She's arriving on Wednesday and will be staying until Sunday next week.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   She             O               O                 Y                arriving       she            PRP     nsubj   
1   's              O               O                 Y                arriving       be             VBZ     aux     
2   arriving        O               O                 Y                arriving       arrive         VBG     ROOT    
3   on              O               O                 Y                arriving       on             IN      prep    
4   Wednesday       B-date_from     B-date_from       Y       DATE     on             Wednesday      NNP     pobj    
5   and             O               O                 Y                arriving       and            CC      cc      
6   will            O               O                 Y                staying        will           MD      aux     
7   be              O               O                 Y                staying        be             VB      aux     
8   staying         O               O                 Y                arriving       stay           VBG     conj    
9   until           O               O                 Y                staying        until          IN      prep    
10  Sunday          B-date_to       B-date               N    DATE     until          Sunday         NNP     pobj    
11  next            I-date_to       I-date               N    DATE     week           next           JJ      amod    
12  week            I-date_to       I-date               N    DATE     staying        week           NN      npadvmod
13  .               O               O                 Y                arriving       .              .       punct   

annotated spans:
Y (4, 5): date_from      
  (10, 13): date_to        

predicted spans:
Y (4, 5): date_from
  (10, 13): date

=============================================================================================

Input: its until the 21st

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   its             O               O                 Y                its            its            PRP$    ROOT    
1   until           O               O                 Y                its            until          IN      prep    
2   the             O               O                 Y       DATE     21st           the            DT      det     
3   21st            B-date_to       B-date_from          N    DATE     until          21st           NN      pobj    

annotated spans:
  (3, 4): date_to        

predicted spans:
  (3, 4): date_from

=============================================================================================

Input: thanks, when will I get the money back?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   thanks          O               O                 Y                get            thank          NNS     intj    
1   ,               O               O                 Y                get            ,              ,       punct   
2   when            O               O                 Y                get            when           WRB     advmod  
3   will            O               O                 Y                get            will           MD      aux     
4   I               O               O                 Y                get            I              PRP     nsubj   
5   get             O               O                 Y                get            get            VB      ROOT    
6   the             O               O                 Y                money          the            DT      det     
7   money           O               O                 Y                get            money          NN      dobj    
8   back            O               O                 Y                get            back           RB      advmod  
9   ?               O               O                 Y                get            ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: why can't I cancel my reservation for tomorrow

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   why             O               O                 Y                cancel         why            WRB     advmod  
1   ca              O               O                 Y                cancel         ca             MD      aux     
2   n't             O               O                 Y                cancel         n't            RB      neg     
3   I               O               O                 Y                cancel         I              PRP     nsubj   
4   cancel          O               O                 Y                cancel         cancel         VB      ROOT    
5   my              O               O                 Y                reservation    my             PRP$    poss    
6   reservation     O               O                 Y                cancel         reservation    NN      dobj    
7   for             O               O                 Y                reservation    for            IN      prep    
8   tomorrow        B-date_from     B-date               N    DATE     for            tomorrow       NN      pobj    

annotated spans:
  (8, 9): date_from      

predicted spans:
  (8, 9): date

=============================================================================================

Input: how can I book a room for 2?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   how             O               O                 Y                book           how            WRB     advmod  
1   can             O               O                 Y                book           can            MD      aux     
2   I               O               O                 Y                book           I              PRP     nsubj   
3   book            O               O                 Y                book           book           VB      ROOT    
4   a               O               B-rooms              N             room           a              DT      det     
5   room            O               I-rooms              N             book           room           NN      dobj    
6   for             O               O                 Y                book           for            IN      prep    
7   2               B-people        B-people          Y       CARDINAL for            2              CD      pobj    
8   ?               O               O                 Y                book           ?              .       punct   

annotated spans:
Y (7, 8): people         

predicted spans:
  (4, 6): rooms
Y (7, 8): people

=============================================================================================

Input: given the new normal, is there any limit on the number of people at the pool?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   given           O               O                 Y                is             give           VBN     prep    
1   the             O               O                 Y                normal         the            DT      det     
2   new             O               O                 Y                normal         new            JJ      amod    
3   normal          O               O                 Y                given          normal         JJ      pobj    
4   ,               O               O                 Y                is             ,              ,       punct   
5   is              O               O                 Y                is             be             VBZ     ROOT    
6   there           O               O                 Y                is             there          EX      expl    
7   any             O               O                 Y                limit          any            DT      det     
8   limit           O               O                 Y                is             limit          NN      attr    
9   on              O               O                 Y                limit          on             IN      prep    
10  the             O               O                 Y                number         the            DT      det     
11  number          O               O                 Y                on             number         NN      pobj    
12  of              O               O                 Y                number         of             IN      prep    
13  people          O               O                 Y                of             people         NNS     pobj    
14  at              O               O                 Y                people         at             IN      prep    
15  the             O               O                 Y                pool           the            DT      det     
16  pool            O               O                 Y                at             pool           NN      pobj    
17  ?               O               O                 Y                is             ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: ok im done with this

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   ok              O               O                 Y                done           ok             UH      intj    
1   i               O               O                 Y                done           I              PRP     nsubjpass
2   m               O               O                 Y                done           m              VBP     auxpass 
3   done            O               O                 Y                done           do             VBN     ROOT    
4   with            O               O                 Y                done           with           IN      prep    
5   this            O               O                 Y                with           this           DT      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I didn't quite understand you

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                understand     I              PRP     nsubj   
1   did             O               O                 Y                understand     did            VBD     aux     
2   n't             O               O                 Y                understand     n't            RB      neg     
3   quite           O               O                 Y                understand     quite          RB      advmod  
4   understand      O               O                 Y                understand     understand     VB      ROOT    
5   you             O               O                 Y                understand     you            PRP     dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: hello, I want to change the number of nights of my hotel booking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   hello           O               O                 Y                want           hello          UH      intj    
1   ,               O               O                 Y                want           ,              ,       punct   
2   I               O               O                 Y                want           I              PRP     nsubj   
3   want            O               O                 Y                want           want           VBP     ROOT    
4   to              O               O                 Y                change         to             TO      aux     
5   change          O               O                 Y                want           change         VB      xcomp   
6   the             O               O                 Y                number         the            DT      det     
7   number          O               O                 Y                change         number         NN      dobj    
8   of              O               O                 Y                number         of             IN      prep    
9   nights          O               O                 Y       TIME     of             night          NNS     pobj    
10  of              O               O                 Y                nights         of             IN      prep    
11  my              O               O                 Y                booking        my             PRP$    poss    
12  hotel           O               O                 Y                booking        hotel          NN      compound
13  booking         O               O                 Y                of             booking        NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: spa team please

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   spa             O               O                 Y                team           spa            NN      compound
1   team            O               O                 Y                please         team           NN      nsubj   
2   please          O               O                 Y                please         please         UH      ROOT    

annotated spans:

predicted spans:

=============================================================================================

Input: is there any way to get in the gym earlier than 4:25

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   is              O               O                 Y                is             be             VBZ     ROOT    
1   there           O               O                 Y                is             there          EX      expl    
2   any             O               O                 Y                way            any            DT      det     
3   way             O               O                 Y                is             way            NN      attr    
4   to              O               O                 Y                get            to             TO      aux     
5   get             O               O                 Y                way            get            VB      relcl   
6   in              O               O                 Y                get            in             IN      prep    
7   the             O               O                 Y       DATE     gym            the            DT      det     
8   gym             O               O                 Y       DATE     in             gym            NN      pobj    
9   earlier         O               O                 Y       DATE     4:25           early          RBR     advmod  
10  than            O               O                 Y                4:25           than           IN      quantmod
11  4:25            B-time          B-number             N    TIME     get            4:25           CD      npadvmod

annotated spans:
  (11, 12): time           

predicted spans:
  (11, 12): number

=============================================================================================

Input: I'd like to check in at 5

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   'd              O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   to              O               O                 Y                check          to             TO      aux     
4   check           O               O                 Y                like           check          VB      xcomp   
5   in              O               O                 Y                check          in             RP      prt     
6   at              O               O                 Y                check          at             IN      prep    
7   5               B-time          B-time            Y       CARDINAL at             5              CD      pobj    

annotated spans:
Y (7, 8): time           

predicted spans:
Y (7, 8): time

=============================================================================================

Input: we're still in the room we are going to leave later

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   we              O               O                 Y                're            we             PRP     nsubj   
1   're             O               O                 Y                're            be             VBP     ROOT    
2   still           O               O                 Y                're            still          RB      advmod  
3   in              O               O                 Y                're            in             IN      prep    
4   the             O               O                 Y                room           the            DT      det     
5   room            O               O                 Y                in             room           NN      pobj    
6   we              O               O                 Y                going          we             PRP     nsubj   
7   are             O               O                 Y                going          be             VBP     aux     
8   going           O               O                 Y                room           go             VBG     relcl   
9   to              O               O                 Y                leave          to             TO      aux     
10  leave           O               O                 Y                going          leave          VB      xcomp   
11  later           O               O                 Y                leave          later          RB      advmod  

annotated spans:

predicted spans:

=============================================================================================

Input: any free rooms with jacuzzi after Tuesday?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   any             O               O                 Y                rooms          any            DT      det     
1   free            O               O                 Y                rooms          free           JJ      amod    
2   rooms           O               O                 Y                rooms          room           NNS     ROOT    
3   with            O               O                 Y                rooms          with           IN      prep    
4   jacuzzi         O               B-person_name        N             with           jacuzzi        NNP     pobj    
5   after           O               O                 Y                rooms          after          IN      prep    
6   Tuesday         B-date_from     B-date_to            N    DATE     after          Tuesday        NNP     pobj    
7   ?               O               O                 Y                rooms          ?              .       punct   

annotated spans:
  (6, 7): date_from      

predicted spans:
  (4, 5): person_name
  (6, 7): date_to

=============================================================================================

Input: Yes, that's brilliant.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Yes             O               O                 Y                's             yes            UH      intj    
1   ,               O               O                 Y                's             ,              ,       punct   
2   that            O               O                 Y                's             that           DT      nsubj   
3   's              O               O                 Y                's             be             VBZ     ROOT    
4   brilliant       O               O                 Y                's             brilliant      JJ      acomp   
5   .               O               O                 Y                's             .              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I made one booking two weeks ago, but would like to make a new one now.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                made           I              PRP     nsubj   
1   made            O               O                 Y                made           make           VBD     ROOT    
2   one             O               O                 Y       CARDINAL booking        one            CD      nsubj   
3   booking         O               O                 Y                made           booking        NN      ccomp   
4   two             B-date          O                    N    DATE     weeks          two            CD      nummod  
5   weeks           I-date          O                    N    DATE     ago            week           NNS     npadvmod
6   ago             I-date          O                    N    DATE     made           ago            RB      advmod  
7   ,               O               O                 Y                made           ,              ,       punct   
8   but             O               O                 Y                made           but            CC      cc      
9   would           O               O                 Y                like           would          MD      aux     
10  like            O               O                 Y                made           like           VB      conj    
11  to              O               O                 Y                make           to             TO      aux     
12  make            O               O                 Y                like           make           VB      xcomp   
13  a               O               O                 Y                one            a              DT      det     
14  new             O               O                 Y                one            new            JJ      amod    
15  one             O               O                 Y                make           one            NN      dobj    
16  now             B-time          O                    N             make           now            RB      advmod  
17  .               O               O                 Y                made           .              .       punct   

annotated spans:
  (4, 7): date           
  (16, 17): time           

predicted spans:

=============================================================================================

Input: I've got a couple of small dogs, is it ok if I bring them

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                got            I              PRP     nsubj   
1   've             O               O                 Y                got            have           VBP     aux     
2   got             O               O                 Y                got            get            VBN     ROOT    
3   a               O               O                 Y                couple         a              DT      det     
4   couple          O               O                 Y                got            couple         NN      dobj    
5   of              O               O                 Y                couple         of             IN      prep    
6   small           O               O                 Y                dogs           small          JJ      amod    
7   dogs            O               O                 Y                of             dog            NNS     pobj    
8   ,               O               O                 Y                got            ,              ,       punct   
9   is              O               O                 Y                got            be             VBZ     conj    
10  it              O               O                 Y                is             it             PRP     nsubj   
11  ok              O               O                 Y                is             ok             JJ      acomp   
12  if              O               O                 Y                bring          if             IN      mark    
13  I               O               O                 Y                bring          I              PRP     nsubj   
14  bring           O               O                 Y                is             bring          VBP     advcl   
15  them            O               O                 Y                bring          they           PRP     dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: no, I don't need a stove in the room.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   no              O               O                 Y                need           no             UH      intj    
1   ,               O               O                 Y                need           ,              ,       punct   
2   I               O               O                 Y                need           I              PRP     nsubj   
3   do              O               O                 Y                need           do             VBP     aux     
4   n't             O               O                 Y                need           n't            RB      neg     
5   need            O               O                 Y                need           need           VB      ROOT    
6   a               O               O                 Y                stove          a              DT      det     
7   stove           O               O                 Y                need           stove          NN      dobj    
8   in              O               O                 Y                stove          in             IN      prep    
9   the             O               O                 Y                room           the            DT      det     
10  room            O               O                 Y                in             room           NN      pobj    
11  .               O               O                 Y                need           .              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: The WiFi signal is so bad.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   The             O               O                 Y                signal         the            DT      det     
1   WiFi            O               O                 Y       PERSON   signal         WiFi           NNP     compound
2   signal          O               O                 Y                is             signal         NN      nsubj   
3   is              O               O                 Y                is             be             VBZ     ROOT    
4   so              O               O                 Y                bad            so             RB      advmod  
5   bad             O               O                 Y                is             bad            JJ      acomp   
6   .               O               O                 Y                is             .              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: there's no shampoo in the shower, please send me one.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   there           O               O                 Y                's             there          EX      expl    
1   's              O               O                 Y                send           be             VBZ     ccomp   
2   no              O               B-adults             N             shampoo        no             DT      det     
3   shampoo         O               O                 Y                's             shampoo        NN      attr    
4   in              O               O                 Y                shampoo        in             IN      prep    
5   the             O               O                 Y                shower         the            DT      det     
6   shower          O               O                 Y                in             shower         NN      pobj    
7   ,               O               O                 Y                send           ,              ,       punct   
8   please          O               O                 Y                send           please         UH      intj    
9   send            O               O                 Y                send           send           VB      ROOT    
10  me              O               O                 Y                send           I              PRP     dative  
11  one             O               O                 Y                send           one            CD      dobj    
12  .               O               O                 Y                send           .              .       punct   

annotated spans:

predicted spans:
  (2, 3): adults

=============================================================================================

Input: does the gym have an exercise bike

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   does            O               O                 Y                have           do             VBZ     aux     
1   the             O               O                 Y                gym            the            DT      det     
2   gym             O               O                 Y                have           gym            NN      nsubj   
3   have            O               O                 Y                have           have           VB      ROOT    
4   an              O               O                 Y                bike           an             DT      det     
5   exercise        O               O                 Y                bike           exercise       NN      compound
6   bike            O               O                 Y                have           bike           NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: how much do body treatments cost?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   how             O               O                 Y                much           how            WRB     advmod  
1   much            O               O                 Y                cost           much           JJ      dobj    
2   do              O               O                 Y                cost           do             VBP     aux     
3   body            O               O                 Y                treatments     body           NN      compound
4   treatments      O               O                 Y                cost           treatment      NNS     nsubj   
5   cost            O               O                 Y                cost           cost           VB      ROOT    
6   ?               O               O                 Y                cost           ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: none

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   none            B-number        O                    N             none           none           NN      ROOT    

annotated spans:
  (0, 1): number         

predicted spans:

=============================================================================================

Input: my daughter left left a teddy bear downstairs did someone hand it in

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   my              O               O                 Y                daughter       my             PRP$    poss    
1   daughter        O               O                 Y                left           daughter       NN      nsubj   
2   left            O               O                 Y                hand           leave          VBD     ccomp   
3   left            O               O                 Y                left           leave          VBD     xcomp   
4   a               O               O                 Y                downstairs     a              DT      det     
5   teddy           O               O                 Y                bear           teddy          NNP     compound
6   bear            O               O                 Y                downstairs     bear           NN      compound
7   downstairs      O               O                 Y                left           downstair      NNS     dobj    
8   did             O               O                 Y                hand           do             VBD     aux     
9   someone         O               O                 Y                hand           someone        NN      nsubj   
10  hand            O               O                 Y                hand           hand           VB      ROOT    
11  it              O               O                 Y                hand           it             PRP     dobj    
12  in              O               O                 Y                hand           in             IN      prep    

annotated spans:

predicted spans:

=============================================================================================

Input: can i leave my car on the parking overnight

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   can             O               O                 Y                leave          can            MD      aux     
1   i               O               O                 Y                leave          I              PRP     nsubj   
2   leave           O               O                 Y                leave          leave          VB      ROOT    
3   my              O               O                 Y                car            my             PRP$    poss    
4   car             O               O                 Y                leave          car            NN      dobj    
5   on              O               O                 Y                leave          on             IN      prep    
6   the             O               O                 Y                parking        the            DT      det     
7   parking         O               O                 Y                on             parking        NN      pobj    
8   overnight       B-time_period   B-date_period        N             leave          overnight      RB      advmod  

annotated spans:
  (8, 9): time_period    

predicted spans:
  (8, 9): date_period

=============================================================================================

Input: till Friday morning

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   till            O               O                 Y                till           till           IN      ROOT    
1   Friday          B-date_to       B-date               N    DATE     morning        Friday         NNP     compound
2   morning         B-time_period   B-time_period     Y       TIME     till           morning        NN      pobj    

annotated spans:
  (1, 2): date_to        
Y (2, 3): time_period    

predicted spans:
  (1, 2): date
Y (2, 3): time_period

=============================================================================================

Input: Cancel the restaurant reservation for 18 45 in the evening under sammijo oaks

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Cancel          O               O                 Y       PRODUCT  Cancel         cancel         VB      ROOT    
1   the             O               O                 Y                reservation    the            DT      det     
2   restaurant      O               O                 Y                reservation    restaurant     NN      compound
3   reservation     O               O                 Y                Cancel         reservation    NN      dobj    
4   for             O               O                 Y                Cancel         for            IN      prep    
5   18              B-time          B-time            Y       DATE     45             18             CD      nummod  
6   45              I-time          I-time            Y       DATE     for            45             CD      pobj    
7   in              I-time          I-time            Y                Cancel         in             IN      prep    
8   the             I-time          O                    N             evening        the            DT      det     
9   evening         I-time          O                    N             in             evening        NN      pobj    
10  under           O               O                 Y                Cancel         under          IN      prep    
11  sammijo         B-person_name   B-person_name     Y                oaks           sammijo        NNP     compound
12  oaks            I-person_name   O                    N             under          oak            NNS     pobj    

annotated spans:
  (5, 10): time           
  (11, 13): person_name    

predicted spans:
  (5, 8): time
  (11, 12): person_name

=============================================================================================

Input: confirm room booking under charis

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   confirm         O               O                 Y                confirm        confirm        VB      ROOT    
1   room            O               O                 Y                booking        room           NN      compound
2   booking         O               O                 Y                confirm        booking        NN      dobj    
3   under           O               O                 Y                booking        under          IN      prep    
4   charis          B-person_name   B-person_name     Y                under          charis         NNP     pobj    

annotated spans:
Y (4, 5): person_name    

predicted spans:
Y (4, 5): person_name

=============================================================================================

Input: do you offer waxing?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   do              O               O                 Y                offer          do             VBP     aux     
1   you             O               O                 Y                offer          you            PRP     nsubj   
2   offer           O               O                 Y                offer          offer          VB      ROOT    
3   waxing          O               O                 Y                offer          wax            VBG     dobj    
4   ?               O               O                 Y                offer          ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: can i book a restaurant table here?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   can             O               O                 Y                book           can            MD      aux     
1   i               O               O                 Y                book           I              PRP     nsubj   
2   book            O               O                 Y                book           book           VB      ROOT    
3   a               O               B-rooms              N             table          a              DT      det     
4   restaurant      O               O                 Y                table          restaurant     NN      compound
5   table           O               O                 Y                book           table          NN      dobj    
6   here            O               O                 Y                book           here           RB      advmod  
7   ?               O               O                 Y                book           ?              .       punct   

annotated spans:

predicted spans:
  (3, 4): rooms

=============================================================================================

Input: please bring me a ham sandwich

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   please          O               O                 Y                bring          please         UH      intj    
1   bring           O               O                 Y                bring          bring          VB      ROOT    
2   me              O               O                 Y                bring          I              PRP     dative  
3   a               O               O                 Y                sandwich       a              DT      det     
4   ham             O               O                 Y                sandwich       ham            NN      compound
5   sandwich        O               O                 Y                bring          sandwich       NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a room booking for Saturday 3 December and I am going to need to change the checkout date to December 12

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                have           I              PRP     nsubj   
1   have            O               O                 Y                have           have           VBP     ROOT    
2   a               B-rooms         O                    N             room           a              DT      det     
3   room            I-rooms         O                    N             have           room           NN      dobj    
4   booking         O               O                 Y                room           book           VBG     acl     
5   for             O               O                 Y                booking        for            IN      prep    
6   Saturday        B-date_from     B-date_from       Y       DATE     for            Saturday       NNP     pobj    
7   3               I-date_from     B-date               N    DATE     Saturday       3              CD      nummod  
8   December        I-date_from     O                    N    DATE     have           December       NNP     npadvmod
9   and             O               O                 Y                have           and            CC      cc      
10  I               O               O                 Y                going          I              PRP     nsubj   
11  am              O               O                 Y                going          be             VBP     aux     
12  going           O               O                 Y                have           go             VBG     conj    
13  to              O               O                 Y                need           to             TO      aux     
14  need            O               O                 Y                going          need           VB      xcomp   
15  to              O               O                 Y                change         to             TO      aux     
16  change          O               O                 Y                need           change         VB      xcomp   
17  the             O               O                 Y                date           the            DT      det     
18  checkout        O               O                 Y                date           checkout       NN      compound
19  date            O               O                 Y                change         date           NN      dobj    
20  to              O               O                 Y                change         to             IN      prep    
21  December        B-date_to       B-date_to         Y       DATE     to             December       NNP     pobj    
22  12              I-date_to       I-date_to         Y       DATE     December       12             CD      nummod  

annotated spans:
  (2, 4): rooms          
  (6, 9): date_from      
Y (21, 23): date_to        

predicted spans:
  (6, 7): date_from
  (7, 8): date
Y (21, 23): date_to

=============================================================================================

Input: change my restaurant reservation to 25 past 15 afternoon

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   change          O               O                 Y                change         change         VB      ROOT    
1   my              O               O                 Y                reservation    my             PRP$    poss    
2   restaurant      O               O                 Y                reservation    restaurant     NN      compound
3   reservation     O               O                 Y                change         reservation    NN      dobj    
4   to              O               O                 Y                change         to             IN      prep    
5   25              B-time          B-time            Y       TIME     afternoon      25             CD      nummod  
6   past            I-time          I-time            Y       TIME     afternoon      past           JJ      amod    
7   15              I-time          I-time            Y       TIME     afternoon      15             CD      nummod  
8   afternoon       I-time          I-time            Y       TIME     to             afternoon      NN      pobj    

annotated spans:
Y (5, 9): time           

predicted spans:
Y (5, 9): time

=============================================================================================

Input: I'm coming with my dad on Thursday, arriving around 8 in the evening

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               B-adults        O                    N             coming         I              PRP     nsubj   
1   'm              I-adults        O                    N             coming         be             VBP     aux     
2   coming          I-adults        O                    N             coming         come           VBG     ROOT    
3   with            I-adults        O                    N             coming         with           IN      prep    
4   my              I-adults        O                    N             dad            my             PRP$    poss    
5   dad             I-adults        O                    N             with           dad            NN      pobj    
6   on              O               O                 Y                coming         on             IN      prep    
7   Thursday        B-date_from     B-date_from       Y       DATE     on             Thursday       NNP     pobj    
8   ,               O               O                 Y                coming         ,              ,       punct   
9   arriving        O               O                 Y                coming         arrive         VBG     advcl   
10  around          O               O                 Y       CARDINAL 8              around         RB      advmod  
11  8               B-time          O                    N    CARDINAL arriving       8              CD      dobj    
12  in              I-time          O                    N             arriving       in             IN      prep    
13  the             I-time          O                    N             evening        the            DT      det     
14  evening         I-time          O                    N    TIME     in             evening        NN      pobj    

annotated spans:
  (0, 6): adults         
Y (7, 8): date_from      
  (11, 15): time           

predicted spans:
Y (7, 8): date_from

=============================================================================================

Input: I want to modify the number of rooms

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                modify         to             TO      aux     
3   modify          O               O                 Y                want           modify         VB      xcomp   
4   the             O               O                 Y                number         the            DT      det     
5   number          O               O                 Y                modify         number         NN      dobj    
6   of              O               O                 Y                number         of             IN      prep    
7   rooms           O               O                 Y                of             room           NNS     pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: book a room from tomorrow to Saturday for 1

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   book            O               O                 Y                book           book           NN      ROOT    
1   a               B-rooms         O                    N             room           a              DT      det     
2   room            I-rooms         O                    N             book           room           NN      appos   
3   from            O               O                 Y                room           from           IN      prep    
4   tomorrow        B-date_from     B-date_from       Y       DATE     from           tomorrow       NN      pobj    
5   to              O               O                 Y       DATE     from           to             IN      prep    
6   Saturday        B-date_to       B-date_to         Y       DATE     to             Saturday       NNP     pobj    
7   for             O               O                 Y                room           for            IN      prep    
8   1               B-people        B-people          Y       CARDINAL for            1              CD      pobj    

annotated spans:
  (1, 3): rooms          
Y (4, 5): date_from      
Y (6, 7): date_to        
Y (8, 9): people         

predicted spans:
Y (4, 5): date_from
Y (6, 7): date_to
Y (8, 9): people

=============================================================================================

Input: new years eve 2025

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   new             B-date          O                    N             years          new            JJ      amod    
1   years           I-date          O                    N             eve            year           NNS     nsubj   
2   eve             I-date          O                    N             eve            eve            VBP     ROOT    
3   2025            I-date          B-number             N    DATE     eve            2025           CD      nummod  

annotated spans:
  (0, 4): date           

predicted spans:
  (3, 4): number

=============================================================================================

Input: 24th Jan 2016

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   24th            B-date          B-date            Y       DATE     Jan            24th           JJ      amod    
1   Jan             I-date          B-date               N    DATE     Jan            Jan            NNP     ROOT    
2   2016            I-date          B-date_to            N    DATE     Jan            2016           CD      nummod  

annotated spans:
  (0, 3): date           

predicted spans:
  (0, 1): date
  (1, 2): date
  (2, 3): date_to

=============================================================================================

Input: A room for three adult people.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   A               B-rooms         B-rooms           Y                room           a              DT      det     
1   room            I-rooms         I-rooms           Y                room           room           NN      ROOT    
2   for             O               O                 Y                room           for            IN      prep    
3   three           B-adults        B-rooms              N    CARDINAL people         three          CD      nummod  
4   adult           O               O                 Y                people         adult          NN      compound
5   people          O               O                 Y                for            people         NNS     pobj    
6   .               O               O                 Y                room           .              .       punct   

annotated spans:
Y (0, 2): rooms          
  (3, 4): adults         

predicted spans:
Y (0, 2): rooms
  (3, 4): rooms

=============================================================================================

Input: I’d like to book two rooms a fortnight today.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   ’d              O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VBP     ROOT    
3   to              O               O                 Y                book           to             TO      aux     
4   book            O               O                 Y                like           book           VB      xcomp   
5   two             B-rooms         O                    N    CARDINAL rooms          two            CD      nummod  
6   rooms           I-rooms         O                    N             book           room           NNS     dobj    
7   a               B-date_from     O                    N             fortnight      a              DT      det     
8   fortnight       I-date_from     O                    N             book           fortnight      JJ      npadvmod
9   today           I-date_from     B-date               N    DATE     book           today          NN      npadvmod
10  .               O               O                 Y                like           .              .       punct   

annotated spans:
  (5, 7): rooms          
  (7, 10): date_from      

predicted spans:
  (9, 10): date

=============================================================================================

Input: book for Aug the 18th to August 26th

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   book            O               O                 Y                book           book           NN      ROOT    
1   for             O               O                 Y                book           for            IN      prep    
2   Aug             B-date_from     O                    N    DATE     for            Aug            NNP     pobj    
3   the             I-date_from     O                    N    DATE     18th           the            DT      det     
4   18th            I-date_from     B-date_from          N    DATE     book           18th           NN      appos   
5   to              O               O                 Y       DATE     book           to             IN      prep    
6   August          B-date_to       B-date_from          N    DATE     26th           August         NNP     compound
7   26th            I-date_to       B-date_to            N    DATE     to             26th           NN      pobj    

annotated spans:
  (2, 5): date_from      
  (6, 8): date_to        

predicted spans:
  (4, 5): date_from
  (6, 7): date_from
  (7, 8): date_to

=============================================================================================

Input: Family room for a weekend break

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Family          O               O                 Y                room           family         NN      compound
1   room            O               O                 Y                room           room           NN      ROOT    
2   for             O               O                 Y                room           for            IN      prep    
3   a               B-date_period   B-date_period     Y                break          a              DT      det     
4   weekend         I-date_period   I-date_period     Y       DATE     break          weekend        NN      compound
5   break           O               O                 Y                for            break          NN      pobj    

annotated spans:
Y (3, 5): date_period    

predicted spans:
Y (3, 5): date_period

=============================================================================================

Input: My husband and I will be arriving on Friday 7th of Jan and plan to stay for 9 days

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   My              B-adults        B-adults          Y                husband        my             PRP$    poss    
1   husband         I-adults        I-adults          Y                arriving       husband        NN      nsubj   
2   and             I-adults        I-adults          Y                husband        and            CC      cc      
3   I               I-adults        O                    N             husband        I              PRP     conj    
4   will            O               O                 Y                arriving       will           MD      aux     
5   be              O               O                 Y                arriving       be             VB      aux     
6   arriving        O               O                 Y                arriving       arrive         VBG     ROOT    
7   on              O               O                 Y                arriving       on             IN      prep    
8   Friday          B-date_from     B-date_from       Y       DATE     7th            Friday         NNP     compound
9   7th             I-date_from     I-date_from       Y       DATE     on             7th            NN      pobj    
10  of              I-date_from     O                    N    DATE     7th            of             IN      prep    
11  Jan             I-date_from     O                    N    DATE     of             Jan            NNP     pobj    
12  and             O               O                 Y                arriving       and            CC      cc      
13  plan            O               O                 Y                arriving       plan           VB      conj    
14  to              O               O                 Y                stay           to             TO      aux     
15  stay            O               O                 Y                plan           stay           VB      xcomp   
16  for             O               O                 Y                stay           for            IN      prep    
17  9               B-date_period   B-date_period     Y       DATE     days           9              CD      nummod  
18  days            I-date_period   I-date_period     Y       DATE     for            day            NNS     pobj    

annotated spans:
  (0, 4): adults         
  (8, 12): date_from      
Y (17, 19): date_period    

predicted spans:
  (0, 3): adults
  (8, 10): date_from
Y (17, 19): date_period

=============================================================================================

Input: arriving on Monday leaving on Thursday 2 adults one child

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   arriving        O               O                 Y                arriving       arrive         VBG     ROOT    
1   on              O               O                 Y                arriving       on             IN      prep    
2   Monday          B-date_from     B-date_from       Y       DATE     on             Monday         NNP     pobj    
3   leaving         O               O                 Y                arriving       leave          VBG     advcl   
4   on              O               O                 Y                leaving        on             IN      prep    
5   Thursday        B-date_to       B-date               N    DATE     on             Thursday       NNP     pobj    
6   2               B-adults        I-date               N    DATE     adults         2              CD      nummod  
7   adults          I-adults        O                    N             Thursday       adult          NNS     appos   
8   one             B-kids          B-kids            Y       CARDINAL child          one            CD      nummod  
9   child           I-kids          O                    N             leaving        child          NN      dobj    

annotated spans:
Y (2, 3): date_from      
  (5, 6): date_to        
  (6, 8): adults         
  (8, 10): kids           

predicted spans:
Y (2, 3): date_from
  (5, 7): date
  (8, 9): kids

=============================================================================================

Input: in total 5 adults and 2 kids

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   in              O               O                 Y                in             in             IN      ROOT    
1   total           O               B-date_to            N             adults         total          JJ      amod    
2   5               B-adults        B-adults          Y       CARDINAL adults         5              CD      nummod  
3   adults          O               O                 Y                in             adult          NNS     pobj    
4   and             O               O                 Y                adults         and            CC      cc      
5   2               B-kids          B-kids            Y       CARDINAL kids           2              CD      nummod  
6   kids            O               O                 Y                adults         kid            NNS     conj    

annotated spans:
Y (2, 3): adults         
Y (5, 6): kids           

predicted spans:
  (1, 2): date_to
Y (2, 3): adults
Y (5, 6): kids

=============================================================================================

Input: We're two adults with 3 kids traveling around Europe.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   We              O               O                 Y                're            we             PRP     nsubj   
1   're             O               O                 Y                're            be             VBP     ROOT    
2   two             B-adults        B-adults          Y       CARDINAL adults         two            CD      nummod  
3   adults          O               O                 Y                're            adult          NNS     attr    
4   with            O               O                 Y                adults         with           IN      prep    
5   3               B-kids          B-kids            Y       CARDINAL kids           3              CD      nummod  
6   kids            O               O                 Y                with           kid            NNS     pobj    
7   traveling       O               O                 Y                kids           travel         VBG     acl     
8   around          O               O                 Y                traveling      around         IN      prep    
9   Europe          O               B-date_from          N    LOC      around         Europe         NNP     pobj    
10  .               O               O                 Y                're            .              .       punct   

annotated spans:
Y (2, 3): adults         
Y (5, 6): kids           

predicted spans:
Y (2, 3): adults
Y (5, 6): kids
  (9, 10): date_from

=============================================================================================

Input: 1 adult

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   1               B-adults        B-adults          Y       CARDINAL adult          1              CD      nummod  
1   adult           I-adults        O                    N             adult          adult          NN      ROOT    

annotated spans:
  (0, 2): adults         

predicted spans:
  (0, 1): adults

=============================================================================================

Input: Arriving Saturday leave on Wednesday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Arriving        O               O                 Y                leave          arrive         VBG     csubj   
1   Saturday        B-date_from     O                    N    DATE     Arriving       Saturday       NNP     npadvmod
2   leave           O               O                 Y                leave          leave          VBP     ROOT    
3   on              O               O                 Y                leave          on             IN      prep    
4   Wednesday       B-date_to       B-date_from          N    DATE     on             Wednesday      NNP     pobj    

annotated spans:
  (1, 2): date_from      
  (4, 5): date_to        

predicted spans:
  (4, 5): date_from

=============================================================================================

Input: leaving on the 12th of Oct arrive on Thursday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   leaving         O               O                 Y                leaving        leave          VBG     ROOT    
1   on              O               O                 Y                leaving        on             IN      prep    
2   the             O               O                 Y       DATE     12th           the            DT      det     
3   12th            B-date_to       B-date_from          N    DATE     on             12th           NN      pobj    
4   of              I-date_to       O                    N             12th           of             IN      prep    
5   Oct             I-date_to       O                    N             arrive         Oct            NNP     compound
6   arrive          O               O                 Y                of             arrive         NN      pobj    
7   on              O               O                 Y                leaving        on             IN      prep    
8   Thursday        B-date_from     B-date_from       Y       DATE     on             Thursday       NNP     pobj    

annotated spans:
  (3, 6): date_to        
Y (8, 9): date_from      

predicted spans:
  (3, 4): date_from
Y (8, 9): date_from

=============================================================================================

Input: I'm leaving on Wednesday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                leaving        I              PRP     nsubj   
1   'm              O               O                 Y                leaving        be             VBP     aux     
2   leaving         O               O                 Y                leaving        leave          VBG     ROOT    
3   on              O               O                 Y                leaving        on             IN      prep    
4   Wednesday       B-date_to       B-date_from          N    DATE     on             Wednesday      NNP     pobj    

annotated spans:
  (4, 5): date_to        

predicted spans:
  (4, 5): date_from

=============================================================================================


Classification report for BIO tags:

               precision    recall  f1-score   support

     B-adults       0.73      0.73      0.73        11
       B-date       0.15      0.22      0.18         9
  B-date_from       0.45      0.53      0.49        19
B-date_period       0.62      1.00      0.77         5
    B-date_to       0.42      0.36      0.38        14
       B-kids       0.67      0.57      0.62         7
     B-number       0.25      0.50      0.33         2
     B-people       0.83      1.00      0.91         5
B-person_name       0.75      0.60      0.67         5
      B-rooms       0.43      0.38      0.40         8
       B-time       0.86      0.60      0.71        10
  B-time_from       0.00      0.00      0.00         1
B-time_period       0.33      0.50      0.40         2
     I-adults       1.00      0.25      0.40        16
       I-date       0.25      0.06      0.10        17
  I-date_from       0.50      0.10      0.17        10
I-date_period       1.00      0.71      0.83         7
    I-date_to       1.00      0.25      0.40         8
       I-kids       0.00      0.00      0.00         3
     I-number       0.00      0.00      0.00         0
     I-people       0.00      0.00      0.00         0
I-person_name       1.00      0.33      0.50         3
      I-rooms       0.67      0.22      0.33         9
       I-time       0.88      0.39      0.54        18
  I-time_from       0.00      0.00      0.00         3
I-time_period       0.00      0.00      0.00         0

    micro avg       0.58      0.40      0.47       192
    macro avg       0.49      0.36      0.38       192
 weighted avg       0.61      0.40      0.44       192


Classification report for slot labels:

              precision    recall  f1-score   support

      adults       0.36      0.36      0.36        11
        date       0.00      0.00      0.00         9
   date_from       0.36      0.42      0.39        19
 date_period       0.50      0.80      0.62         5
     date_to       0.42      0.36      0.38        14
        kids       0.50      0.43      0.46         7
      number       0.25      0.50      0.33         2
      people       0.83      1.00      0.91         5
 person_name       0.50      0.40      0.44         5
       rooms       0.29      0.25      0.27         8
        time       0.43      0.30      0.35        10
   time_from       0.00      0.00      0.00         1
 time_period       0.33      0.50      0.40         2

   micro avg       0.37      0.39      0.38        98
   macro avg       0.37      0.41      0.38        98
weighted avg       0.38      0.39      0.38        98


