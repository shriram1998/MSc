> Reading training data from data\training_data.json...
> Reading validation data from data\validation_data.json...
> Tokenising and annotating raw data with spacy...
> Training logistic_regression model on training data...
> Finished training logistic regression on 7348 tokens
> Predicting tags on validation data...
> Evaluating results on validation data...
Input: I would like to check in the 4 April and check out the Wednesday, thanks

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       like           I              PRP     nsubj   
1   would           O               O                 Y       like           would          MD      aux     
2   like            O               O                 Y       like           like           VB      ROOT    
3   to              O               O                 Y       check          to             TO      aux     
4   check           O               O                 Y       like           check          VB      xcomp   
5   in              O               O                 Y       check          in             IN      prep    
6   the             O               O                 Y       April          the            DT      det     
7   4               B-date_from     B-date_from       Y       April          4              CD      nummod  
8   April           I-date_from     I-date_from       Y       in             April          NNP     pobj    
9   and             O               O                 Y       check          and            CC      cc      
10  check           O               O                 Y       check          check          VB      conj    
11  out             O               O                 Y       check          out            RP      prt     
12  the             O               O                 Y       Wednesday      the            DT      det     
13  Wednesday       B-date_to       I-date_from          N    check          Wednesday      NNP     dobj    
14  ,               O               O                 Y       check          ,              ,       punct   
15  thanks          O               O                 Y       like           thank          NNS     npadvmod

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (7, 9): date_from      
  (13, 14): date_to        

predicted spans (incorrectly extracted from BIO tags):
Y (7, 9): date_from

=============================================================================================

Input: I am still waiting for the refund of the room i cancelled

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       waiting        I              PRP     nsubj   
1   am              O               O                 Y       waiting        be             VBP     aux     
2   still           O               O                 Y       waiting        still          RB      advmod  
3   waiting         O               O                 Y       waiting        wait           VBG     ROOT    
4   for             O               O                 Y       waiting        for            IN      prep    
5   the             O               O                 Y       refund         the            DT      det     
6   refund          O               O                 Y       for            refund         NN      pobj    
7   of              O               O                 Y       refund         of             IN      prep    
8   the             B-rooms         O                    N    room           the            DT      det     
9   room            I-rooms         O                    N    of             room           NN      pobj    
10  i               O               O                 Y       cancelled      I              PRP     nsubj   
11  cancelled       O               O                 Y       room           cancel         VBD     relcl   

annotated spans:
  (8, 10): rooms          

predicted spans:

=============================================================================================

Input: what time do the cleaning personel come?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   what            O               O                 Y       time           what           WDT     det     
1   time            O               O                 Y       come           time           NN      dobj    
2   do              O               O                 Y       come           do             VBP     aux     
3   the             O               O                 Y       personel       the            DT      det     
4   cleaning        O               O                 Y       personel       cleaning       NN      compound
5   personel        O               O                 Y       come           personel       NN      nsubj   
6   come            O               O                 Y       come           come           VB      ROOT    
7   ?               O               O                 Y       come           ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: how much does a full body massage last?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   how             O               O                 Y       much           how            WRB     advmod  
1   much            O               O                 Y       last           much           JJ      advmod  
2   does            O               O                 Y       last           do             VBZ     aux     
3   a               O               B-rooms              N    massage        a              DT      det     
4   full            O               O                 Y       massage        full           JJ      amod    
5   body            O               O                 Y       massage        body           NN      compound
6   massage         O               O                 Y       last           massage        NN      nsubj   
7   last            O               O                 Y       last           last           JJ      ROOT    
8   ?               O               O                 Y       last           ?              .       punct   

annotated spans:

predicted spans:
  (3, 4): rooms

=============================================================================================

Input: ok, then I need a wheelchair friendly room

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   ok              O               O                 Y       need           ok             UH      intj    
1   ,               O               O                 Y       need           ,              ,       punct   
2   then            O               O                 Y       need           then           RB      advmod  
3   I               O               O                 Y       need           I              PRP     nsubj   
4   need            O               O                 Y       need           need           VBP     ROOT    
5   a               B-rooms         O                    N    room           a              DT      det     
6   wheelchair      I-rooms         O                    N    friendly       wheelchair     NN      npadvmod
7   friendly        I-rooms         B-person_name        N    room           friendly       JJ      amod    
8   room            I-rooms         I-rooms           Y       need           room           NN      dobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (5, 9): rooms          

predicted spans (incorrectly extracted from BIO tags):
  (7, 9): person_name

=============================================================================================

Input: i lost it, but don't know where

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y       lost           I              PRP     nsubj   
1   lost            O               O                 Y       lost           lose           VBD     ROOT    
2   it              O               O                 Y       lost           it             PRP     dobj    
3   ,               O               O                 Y       lost           ,              ,       punct   
4   but             O               O                 Y       lost           but            CC      cc      
5   do              O               O                 Y       know           do             VBP     aux     
6   n't             O               O                 Y       know           n't            RB      neg     
7   know            O               O                 Y       lost           know           VB      conj    
8   where           O               O                 Y       know           where          WRB     ccomp   

annotated spans:

predicted spans:

=============================================================================================

Input: i lost it, but no idea where

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y       lost           I              PRP     nsubj   
1   lost            O               O                 Y       lost           lose           VBD     ROOT    
2   it              O               O                 Y       lost           it             PRP     dobj    
3   ,               O               O                 Y       lost           ,              ,       punct   
4   but             O               O                 Y       lost           but            CC      cc      
5   no              O               O                 Y       idea           no             DT      det     
6   idea            O               O                 Y       lost           idea           NN      conj    
7   where           O               O                 Y       idea           where          WRB     advmod  

annotated spans:

predicted spans:

=============================================================================================

Input: Goodbye, my virtual friend!

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Goodbye         O               I-adults             N    Goodbye        Goodbye        NNP     ROOT    
1   ,               O               O                 Y       Goodbye        ,              ,       punct   
2   my              O               O                 Y       friend         my             PRP$    poss    
3   virtual         O               O                 Y       friend         virtual        JJ      amod    
4   friend          O               O                 Y       Goodbye        friend         NN      appos   
5   !               O               O                 Y       Goodbye        !              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: hiya there, I need some info about my current booking at your place

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   hiya            O               O                 Y       need           hiya           NNP     advmod  
1   there           O               O                 Y       need           there          RB      advmod  
2   ,               O               O                 Y       need           ,              ,       punct   
3   I               O               O                 Y       need           I              PRP     nsubj   
4   need            O               O                 Y       need           need           VBP     ROOT    
5   some            O               O                 Y       info           some           DT      det     
6   info            O               O                 Y       need           info           NN      dobj    
7   about           O               O                 Y       info           about          IN      prep    
8   my              O               O                 Y       booking        my             PRP$    poss    
9   current         O               O                 Y       booking        current        JJ      amod    
10  booking         O               O                 Y       about          booking        NN      pobj    
11  at              O               O                 Y       need           at             IN      prep    
12  your            O               O                 Y       place          your           PRP$    poss    
13  place           O               O                 Y       at             place          NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I need to speak to someone working at the pool.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       need           I              PRP     nsubj   
1   need            O               O                 Y       need           need           VBP     ROOT    
2   to              O               O                 Y       speak          to             TO      aux     
3   speak           O               O                 Y       need           speak          VB      xcomp   
4   to              O               O                 Y       speak          to             IN      prep    
5   someone         O               O                 Y       to             someone        NN      pobj    
6   working         O               O                 Y       someone        work           VBG     acl     
7   at              O               O                 Y       working        at             IN      prep    
8   the             O               O                 Y       pool           the            DT      det     
9   pool            O               O                 Y       at             pool           NN      pobj    
10  .               O               O                 Y       need           .              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: It will be fewer people today than what I first told you.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   It              O               O                 Y       be             it             PRP     nsubj   
1   will            O               O                 Y       be             will           MD      aux     
2   be              O               O                 Y       be             be             VB      ROOT    
3   fewer           O               O                 Y       people         few            JJR     amod    
4   people          O               O                 Y       be             people         NNS     attr    
5   today           B-date          B-date            Y       be             today          NN      npadvmod
6   than            O               O                 Y       be             than           IN      prep    
7   what            O               O                 Y       told           what           WP      dative  
8   I               O               O                 Y       told           I              PRP     nsubj   
9   first           O               O                 Y       told           first          RB      advmod  
10  told            O               O                 Y       than           tell           VBD     pcomp   
11  you             O               O                 Y       told           you            PRP     dobj    
12  .               O               O                 Y       be             .              .       punct   

annotated spans:
Y (5, 6): date           

predicted spans:
Y (5, 6): date

=============================================================================================

Input: when can I do check in very latest?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   when            O               O                 Y       check          when           WRB     advmod  
1   can             O               O                 Y       check          can            MD      aux     
2   I               O               O                 Y       check          I              PRP     nsubj   
3   do              O               O                 Y       check          do             VB      aux     
4   check           O               O                 Y       check          check          VB      ROOT    
5   in              O               O                 Y       check          in             IN      prep    
6   very            O               O                 Y       latest         very           RB      advmod  
7   latest          O               O                 Y       check          late           JJS     advmod  
8   ?               O               O                 Y       check          ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I want to check out, but still leave my car at the parking spot for few more hours.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       want           I              PRP     nsubj   
1   want            O               O                 Y       want           want           VBP     ROOT    
2   to              O               O                 Y       check          to             TO      aux     
3   check           O               O                 Y       want           check          VB      xcomp   
4   out             O               O                 Y       check          out            RP      prt     
5   ,               O               O                 Y       want           ,              ,       punct   
6   but             O               O                 Y       want           but            CC      cc      
7   still           O               O                 Y       leave          still          RB      advmod  
8   leave           O               O                 Y       want           leave          VB      conj    
9   my              O               O                 Y       car            my             PRP$    poss    
10  car             O               O                 Y       leave          car            NN      dobj    
11  at              O               O                 Y       leave          at             IN      prep    
12  the             O               O                 Y       spot           the            DT      det     
13  parking         O               O                 Y       spot           parking        NN      compound
14  spot            O               O                 Y       at             spot           NN      pobj    
15  for             O               O                 Y       leave          for            IN      prep    
16  few             B-time_period   O                    N    hours          few            JJ      amod    
17  more            I-time_period   I-kids               N    hours          more           JJR     amod    
18  hours           I-time_period   O                    N    for            hour           NNS     pobj    
19  .               O               O                 Y       want           .              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (16, 19): time_period    

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: I'd like to rebook for a later date, say, Wednesday 26th October

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       like           I              PRP     nsubj   
1   'd              O               O                 Y       like           would          MD      aux     
2   like            O               O                 Y       like           like           VB      ROOT    
3   to              O               O                 Y       rebook         to             TO      aux     
4   rebook          O               O                 Y       like           rebook         VB      xcomp   
5   for             O               O                 Y       rebook         for            IN      prep    
6   a               O               O                 Y       date           a              DT      det     
7   later           O               O                 Y       date           later          JJ      amod    
8   date            O               O                 Y       for            date           NN      pobj    
9   ,               O               O                 Y       rebook         ,              ,       punct   
10  say             O               B-date_from          N    rebook         say            UH      intj    
11  ,               O               O                 Y       rebook         ,              ,       punct   
12  Wednesday       B-date_from     B-date               N    26th           Wednesday      NNP     compound
13  26th            I-date_from     I-date_from       Y       rebook         26th           NN      npadvmod
14  October         I-date_from     I-date_to            N    like           October        NNP     npadvmod

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (12, 15): date_from      

predicted spans (incorrectly extracted from BIO tags):
  (10, 11): date_from
  (12, 15): date

=============================================================================================

Input: new

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   new             O               O                 Y       new            new            JJ      ROOT    

annotated spans:

predicted spans:

=============================================================================================

Input: Where exactly is the pool?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Where           O               O                 Y       exactly        where          WRB     advmod  
1   exactly         O               O                 Y       is             exactly        RB      advmod  
2   is              O               O                 Y       is             be             VBZ     ROOT    
3   the             O               O                 Y       pool           the            DT      det     
4   pool            O               O                 Y       is             pool           NN      nsubj   
5   ?               O               O                 Y       is             ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I have just one dog I wanted to have in my room, can I make sure that is ok

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       have           I              PRP     nsubj   
1   have            O               O                 Y       make           have           VBP     ccomp   
2   just            O               O                 Y       one            just           RB      advmod  
3   one             O               B-adults             N    dog            one            CD      nummod  
4   dog             O               O                 Y       have           dog            NN      dobj    
5   I               O               O                 Y       wanted         I              PRP     nsubj   
6   wanted          O               O                 Y       dog            want           VBD     relcl   
7   to              O               O                 Y       have           to             TO      aux     
8   have            O               O                 Y       wanted         have           VB      xcomp   
9   in              O               O                 Y       have           in             IN      prep    
10  my              O               O                 Y       room           my             PRP$    poss    
11  room            O               O                 Y       in             room           NN      pobj    
12  ,               O               O                 Y       make           ,              ,       punct   
13  can             O               O                 Y       make           can            MD      aux     
14  I               O               O                 Y       make           I              PRP     nsubj   
15  make            O               O                 Y       make           make           VB      ROOT    
16  sure            O               O                 Y       make           sure           JJ      ccomp   
17  that            O               O                 Y       is             that           DT      nsubj   
18  is              O               O                 Y       sure           be             VBZ     ccomp   
19  ok              O               O                 Y       is             ok             JJ      acomp   

annotated spans:

predicted spans:
  (3, 4): adults

=============================================================================================

Input: heck no!

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   heck            O               O                 Y       heck           heck           UH      ROOT    
1   no              O               O                 Y       heck           no             UH      intj    
2   !               O               O                 Y       heck           !              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: Do you guys have a WiFi password?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Do              O               O                 Y       have           do             VBP     aux     
1   you             O               O                 Y       guys           you            PRP     nmod    
2   guys            O               O                 Y       have           guy            NNS     nsubj   
3   have            O               O                 Y       have           have           VB      ROOT    
4   a               O               O                 Y       password       a              DT      det     
5   WiFi            O               O                 Y       password       WiFi           NNP     compound
6   password        O               O                 Y       have           password       NN      dobj    
7   ?               O               O                 Y       have           ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: Can someone fix air conditioning in my room, please?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Can             O               O                 Y       fix            can            MD      aux     
1   someone         O               O                 Y       fix            someone        NN      nsubj   
2   fix             O               O                 Y       please         fix            VB      ccomp   
3   air             O               O                 Y       conditioning   air            NN      compound
4   conditioning    O               O                 Y       fix            conditioning   NN      dobj    
5   in              O               O                 Y       fix            in             IN      prep    
6   my              O               O                 Y       room           my             PRP$    poss    
7   room            O               O                 Y       in             room           NN      pobj    
8   ,               O               O                 Y       please         ,              ,       punct   
9   please          O               O                 Y       please         please         UH      ROOT    
10  ?               O               O                 Y       please         ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: having a jacuzzi is definitely more than what I expected

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   having          O               O                 Y       is             have           VBG     csubj   
1   a               O               O                 Y       jacuzzi        a              DT      det     
2   jacuzzi         O               O                 Y       having         jacuzzi        NN      dobj    
3   is              O               O                 Y       is             be             VBZ     ROOT    
4   definitely      O               O                 Y       is             definitely     RB      advmod  
5   more            O               O                 Y       is             more           JJR     acomp   
6   than            O               O                 Y       more           than           IN      prep    
7   what            O               O                 Y       expected       what           WP      dobj    
8   I               O               O                 Y       expected       I              PRP     nsubj   
9   expected        O               O                 Y       than           expect         VBD     pcomp   

annotated spans:

predicted spans:

=============================================================================================

Input: I heard there you have a jogging trail

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       heard          I              PRP     nsubj   
1   heard           O               O                 Y       heard          hear           VBD     ROOT    
2   there           O               O                 Y       heard          there          RB      advmod  
3   you             O               O                 Y       have           you            PRP     nsubj   
4   have            O               O                 Y       heard          have           VBP     ccomp   
5   a               O               O                 Y       trail          a              DT      det     
6   jogging         O               O                 Y       trail          jog            VBG     amod    
7   trail           O               O                 Y       have           trail          NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: How much is extra parking?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   How             O               O                 Y       much           how            WRB     advmod  
1   much            O               O                 Y       is             much           JJ      acomp   
2   is              O               O                 Y       is             be             VBZ     ROOT    
3   extra           O               O                 Y       parking        extra          JJ      amod    
4   parking         O               O                 Y       is             parking        NN      nsubj   
5   ?               O               O                 Y       is             ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: We'll be coming with 1 cars and will probably need the same number of parking spots.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   We              O               O                 Y       coming         we             PRP     nsubj   
1   'll             O               O                 Y       coming         'll            MD      aux     
2   be              O               O                 Y       coming         be             VB      aux     
3   coming          O               O                 Y       coming         come           VBG     ROOT    
4   with            O               O                 Y       coming         with           IN      prep    
5   1               B-number        B-kids               N    cars           1              CD      nummod  
6   cars            O               O                 Y       with           car            NNS     pobj    
7   and             O               O                 Y       coming         and            CC      cc      
8   will            O               O                 Y       need           will           MD      aux     
9   probably        O               O                 Y       need           probably       RB      advmod  
10  need            O               O                 Y       coming         need           VB      conj    
11  the             O               O                 Y       number         the            DT      det     
12  same            O               O                 Y       number         same           JJ      amod    
13  number          O               O                 Y       need           number         NN      dobj    
14  of              O               O                 Y       number         of             IN      prep    
15  parking         O               O                 Y       spots          parking        NN      compound
16  spots           O               O                 Y       of             spot           NNS     pobj    
17  .               O               O                 Y       coming         .              .       punct   

annotated spans:
  (5, 6): number         

predicted spans:
  (5, 6): kids

=============================================================================================

Input: my camera seems to be missing

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   my              O               O                 Y       camera         my             PRP$    poss    
1   camera          O               O                 Y       seems          camera         NN      nsubj   
2   seems           O               O                 Y       seems          seem           VBZ     ROOT    
3   to              O               O                 Y       missing        to             TO      aux     
4   be              O               O                 Y       missing        be             VB      aux     
5   missing         O               O                 Y       seems          miss           VBG     xcomp   

annotated spans:

predicted spans:

=============================================================================================

Input: Where can I leave my car?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Where           O               O                 Y       leave          where          WRB     advmod  
1   can             O               O                 Y       leave          can            MD      aux     
2   I               O               O                 Y       leave          I              PRP     nsubj   
3   leave           O               O                 Y       leave          leave          VB      ROOT    
4   my              O               O                 Y       car            my             PRP$    poss    
5   car             O               O                 Y       leave          car            NN      dobj    
6   ?               O               O                 Y       leave          ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: any room free this evening already?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   any             O               O                 Y       room           any            DT      det     
1   room            O               O                 Y       free           room           NN      nsubj   
2   free            O               O                 Y       free           free           JJ      ROOT    
3   this            B-time_period   O                    N    evening        this           DT      det     
4   evening         I-time_period   O                    N    free           evening        NN      npadvmod
5   already         O               O                 Y       free           already        RB      advmod  
6   ?               O               O                 Y       free           ?              .       punct   

annotated spans:
  (3, 5): time_period    

predicted spans:

=============================================================================================

Input: cancel the 8 40 in the morning restaurant booking under bruggeman

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   cancel          O               O                 Y       cancel         cancel         VB      ROOT    
1   the             O               O                 Y       40             the            DT      det     
2   8               B-time          B-time            Y       40             8              CD      compound
3   40              I-time          I-time            Y       cancel         40             CD      dobj    
4   in              I-time          I-time            Y       cancel         in             IN      prep    
5   the             I-time          O                    N    booking        the            DT      det     
6   morning         I-time          B-time_period        N    booking        morning        NN      compound
7   restaurant      O               O                 Y       booking        restaurant     NN      compound
8   booking         O               O                 Y       in             booking        NN      pobj    
9   under           O               O                 Y       cancel         under          IN      prep    
10  bruggeman       B-person_name   B-date_to            N    under          bruggeman      NN      pobj    

annotated spans:
  (2, 7): time           
  (10, 11): person_name    

predicted spans:
  (2, 5): time
  (6, 7): time_period
  (10, 11): date_to

=============================================================================================

Input: I want to book a room on behalf of shaida sharon, from Jan the 12th.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       want           I              PRP     nsubj   
1   want            O               O                 Y       want           want           VBP     ROOT    
2   to              O               O                 Y       book           to             TO      aux     
3   book            O               O                 Y       want           book           VB      xcomp   
4   a               O               B-rooms              N    room           a              DT      det     
5   room            O               O                 Y       book           room           NN      dobj    
6   on              O               O                 Y       room           on             IN      prep    
7   behalf          O               O                 Y       on             behalf         NN      pobj    
8   of              O               O                 Y       behalf         of             IN      prep    
9   shaida          B-person_name   B-person_name     Y       sharon         shaida         NNP     compound
10  sharon          I-person_name   I-person_name     Y       of             sharon         NNP     pobj    
11  ,               O               O                 Y       book           ,              ,       punct   
12  from            O               O                 Y       book           from           IN      prep    
13  Jan             B-date_from     B-date_from       Y       from           Jan            NNP     pobj    
14  the             I-date_from     I-date_from       Y       12th           the            DT      det     
15  12th            I-date_from     B-date_from          N    Jan            12th           NN      appos   
16  .               O               O                 Y       want           .              .       punct   

annotated spans:
Y (9, 11): person_name    
  (13, 16): date_from      

predicted spans:
  (4, 5): rooms
Y (9, 11): person_name
  (13, 15): date_from
  (15, 16): date_from

=============================================================================================

Input: I want to get a foot bath on Sunday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       want           I              PRP     nsubj   
1   want            O               O                 Y       want           want           VBP     ROOT    
2   to              O               O                 Y       get            to             TO      aux     
3   get             O               O                 Y       want           get            VB      xcomp   
4   a               O               O                 Y       bath           a              DT      det     
5   foot            O               O                 Y       bath           foot           NN      compound
6   bath            O               O                 Y       get            bath           NN      dobj    
7   on              O               O                 Y       bath           on             IN      prep    
8   Sunday          B-date          B-date_from          N    on             Sunday         NNP     pobj    

annotated spans:
  (8, 9): date           

predicted spans:
  (8, 9): date_from

=============================================================================================

Input: Is there a cash machine on the premises?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Is              O               O                 Y       Is             be             VBZ     ROOT    
1   there           O               O                 Y       Is             there          EX      expl    
2   a               O               B-rooms              N    machine        a              DT      det     
3   cash            O               O                 Y       machine        cash           NN      compound
4   machine         O               O                 Y       Is             machine        NN      attr    
5   on              O               O                 Y       machine        on             IN      prep    
6   the             O               O                 Y       premises       the            DT      det     
7   premises        O               O                 Y       on             premise        NNS     pobj    
8   ?               O               O                 Y       Is             ?              .       punct   

annotated spans:

predicted spans:
  (2, 3): rooms

=============================================================================================

Input: speak to room service

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   speak           O               O                 Y       speak          speak          VB      ROOT    
1   to              O               O                 Y       room           to             TO      aux     
2   room            O               O                 Y       service        room           NN      compound
3   service         O               O                 Y       speak          service        NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a reservation and I need to change the number of adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       have           I              PRP     nsubj   
1   have            O               O                 Y       have           have           VBP     ROOT    
2   a               O               O                 Y       reservation    a              DT      det     
3   reservation     O               O                 Y       have           reservation    NN      dobj    
4   and             O               O                 Y       have           and            CC      cc      
5   I               O               O                 Y       need           I              PRP     nsubj   
6   need            O               O                 Y       have           need           VBP     conj    
7   to              O               O                 Y       change         to             TO      aux     
8   change          O               O                 Y       need           change         VB      xcomp   
9   the             O               O                 Y       number         the            DT      det     
10  number          O               O                 Y       change         number         NN      dobj    
11  of              O               O                 Y       number         of             IN      prep    
12  adults          O               O                 Y       of             adult          NNS     pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a booking and I need to amend the number of adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       have           I              PRP     nsubj   
1   have            O               O                 Y       have           have           VBP     ROOT    
2   a               O               O                 Y       booking        a              DT      det     
3   booking         O               O                 Y       have           booking        NN      dobj    
4   and             O               O                 Y       have           and            CC      cc      
5   I               O               O                 Y       need           I              PRP     nsubj   
6   need            O               O                 Y       have           need           VBP     conj    
7   to              O               O                 Y       amend          to             TO      aux     
8   amend           O               O                 Y       need           amend          VB      xcomp   
9   the             O               O                 Y       number         the            DT      det     
10  number          O               O                 Y       amend          number         NN      dobj    
11  of              O               O                 Y       number         of             IN      prep    
12  adults          O               O                 Y       of             adult          NNS     pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a booking and I need to change the number of adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       have           I              PRP     nsubj   
1   have            O               O                 Y       have           have           VBP     ROOT    
2   a               O               O                 Y       booking        a              DT      det     
3   booking         O               O                 Y       have           booking        NN      dobj    
4   and             O               O                 Y       have           and            CC      cc      
5   I               O               O                 Y       need           I              PRP     nsubj   
6   need            O               O                 Y       have           need           VBP     conj    
7   to              O               O                 Y       change         to             TO      aux     
8   change          O               O                 Y       need           change         VB      xcomp   
9   the             O               O                 Y       number         the            DT      det     
10  number          O               O                 Y       change         number         NN      dobj    
11  of              O               O                 Y       number         of             IN      prep    
12  adults          O               O                 Y       of             adult          NNS     pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a reservation and I need to amend the number of adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       have           I              PRP     nsubj   
1   have            O               O                 Y       have           have           VBP     ROOT    
2   a               O               O                 Y       reservation    a              DT      det     
3   reservation     O               O                 Y       have           reservation    NN      dobj    
4   and             O               O                 Y       have           and            CC      cc      
5   I               O               O                 Y       need           I              PRP     nsubj   
6   need            O               O                 Y       have           need           VBP     conj    
7   to              O               O                 Y       amend          to             TO      aux     
8   amend           O               O                 Y       need           amend          VB      xcomp   
9   the             O               O                 Y       number         the            DT      det     
10  number          O               O                 Y       amend          number         NN      dobj    
11  of              O               O                 Y       number         of             IN      prep    
12  adults          O               O                 Y       of             adult          NNS     pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: please change the time of my table booking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   please          O               O                 Y       change         please         UH      intj    
1   change          O               O                 Y       change         change         VB      ROOT    
2   the             O               O                 Y       time           the            DT      det     
3   time            O               O                 Y       change         time           NN      dobj    
4   of              O               O                 Y       time           of             IN      prep    
5   my              O               O                 Y       booking        my             PRP$    poss    
6   table           O               O                 Y       booking        table          NN      compound
7   booking         O               O                 Y       of             booking        NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I want to modify the adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       want           I              PRP     nsubj   
1   want            O               O                 Y       want           want           VBP     ROOT    
2   to              O               O                 Y       modify         to             TO      aux     
3   modify          O               O                 Y       want           modify         VB      xcomp   
4   the             O               O                 Y       adults         the            DT      det     
5   adults          O               O                 Y       modify         adult          NNS     dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: Looking for a room from the 1st to the 17th for 8 people

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Looking         O               O                 Y       Looking        look           VBG     ROOT    
1   for             O               O                 Y       Looking        for            IN      prep    
2   a               O               O                 Y       room           a              DT      det     
3   room            O               I-rooms              N    for            room           NN      pobj    
4   from            O               O                 Y       room           from           IN      prep    
5   the             O               O                 Y       1st            the            DT      det     
6   1st             B-date_from     B-date_from       Y       from           1st            NN      pobj    
7   to              O               O                 Y       Looking        to             IN      prep    
8   the             O               O                 Y       17th           the            DT      det     
9   17th            B-date_to       B-date_from          N    to             17th           NN      pobj    
10  for             O               O                 Y       Looking        for            IN      prep    
11  8               B-people        B-people          Y       people         8              CD      nummod  
12  people          O               O                 Y       for            people         NNS     pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (6, 7): date_from      
  (9, 10): date_to        
Y (11, 12): people         

predicted spans (incorrectly extracted from BIO tags):
Y (6, 7): date_from
  (9, 10): date_from
Y (11, 12): people

=============================================================================================

Input: Tuesday March 3

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Tuesday         B-date          B-date            Y       March          Tuesday        NNP     compound
1   March           I-date          I-date            Y       March          March          NNP     ROOT    
2   3               I-date          I-date_from          N    March          3              CD      nummod  

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (0, 3): date           

predicted spans (incorrectly extracted from BIO tags):
Y (0, 3): date

=============================================================================================

Input: Sunday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Sunday          B-date          B-date            Y       Sunday         Sunday         NNP     ROOT    

annotated spans:
Y (0, 1): date           

predicted spans:
Y (0, 1): date

=============================================================================================

Input: I'd like an en suite room for 2 adults please

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       like           I              PRP     nsubj   
1   'd              O               O                 Y       like           would          MD      aux     
2   like            O               O                 Y       like           like           VB      ROOT    
3   an              B-rooms         O                    N    room           an             DT      det     
4   en              I-rooms         O                    N    room           en             FW      compound
5   suite           I-rooms         I-rooms           Y       room           suite          NN      compound
6   room            I-rooms         I-rooms           Y       like           room           NN      dobj    
7   for             O               O                 Y       room           for            IN      prep    
8   2               B-adults        B-adults          Y       adults         2              CD      nummod  
9   adults          I-adults        O                    N    for            adult          NNS     pobj    
10  please          O               O                 Y       like           please         UH      intj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (3, 7): rooms          
  (8, 10): adults         

predicted spans (incorrectly extracted from BIO tags):
  (8, 9): adults

=============================================================================================

Input: a double room for tomorrow for 8 days

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   a               B-rooms         B-rooms           Y       room           a              DT      det     
1   double          I-rooms         I-rooms           Y       room           double         JJ      amod    
2   room            I-rooms         I-rooms           Y       room           room           NN      ROOT    
3   for             O               O                 Y       room           for            IN      prep    
4   tomorrow        B-date_from     O                    N    for            tomorrow       NN      pobj    
5   for             O               O                 Y       room           for            IN      prep    
6   8               B-date_period   B-date_period     Y       days           8              CD      nummod  
7   days            I-date_period   I-date_period     Y       for            day            NNS     pobj    

annotated spans:
Y (0, 3): rooms          
  (4, 5): date_from      
Y (6, 8): date_period    

predicted spans:
Y (0, 3): rooms
Y (6, 8): date_period

=============================================================================================

Input: From the 16th to the 30th, a single room for 2 adults and 1 child.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   From            O               O                 Y       room           from           IN      prep    
1   the             O               O                 Y       16th           the            DT      det     
2   16th            B-date_from     B-date_from       Y       From           16th           NN      pobj    
3   to              O               O                 Y       From           to             IN      prep    
4   the             O               O                 Y       30th           the            DT      det     
5   30th            B-date_to       I-date_from          N    to             30th           NN      pobj    
6   ,               O               O                 Y       room           ,              ,       punct   
7   a               B-rooms         O                    N    room           a              DT      det     
8   single          I-rooms         I-rooms           Y       room           single         JJ      amod    
9   room            I-rooms         I-rooms           Y       room           room           NN      ROOT    
10  for             O               O                 Y       room           for            IN      prep    
11  2               B-adults        B-adults          Y       adults         2              CD      nummod  
12  adults          O               O                 Y       for            adult          NNS     pobj    
13  and             O               O                 Y       adults         and            CC      cc      
14  1               B-kids          B-kids            Y       child          1              CD      nummod  
15  child           O               O                 Y       adults         child          NN      conj    
16  .               O               O                 Y       room           .              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (2, 3): date_from      
  (5, 6): date_to        
  (7, 10): rooms          
Y (11, 12): adults         
Y (14, 15): kids           

predicted spans (incorrectly extracted from BIO tags):
Y (2, 3): date_from
Y (11, 12): adults
Y (14, 15): kids

=============================================================================================

Input: I want to book for today

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       want           I              PRP     nsubj   
1   want            O               O                 Y       want           want           VBP     ROOT    
2   to              O               O                 Y       book           to             TO      aux     
3   book            O               O                 Y       want           book           VB      xcomp   
4   for             O               O                 Y       book           for            IN      prep    
5   today           B-date_from     O                    N    for            today          NN      pobj    

annotated spans:
  (5, 6): date_from      

predicted spans:

=============================================================================================

Input: for a week

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   for             O               O                 Y       for            for            IN      ROOT    
1   a               B-date_period   B-date_period     Y       week           a              DT      det     
2   week            I-date_period   I-date_period     Y       for            week           NN      pobj    

annotated spans:
Y (1, 3): date_period    

predicted spans:
Y (1, 3): date_period

=============================================================================================

Input: 5 nights from 15th of October?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   5               B-date_period   B-date_period     Y       nights         5              CD      nummod  
1   nights          I-date_period   I-date_period     Y       nights         night          NNS     ROOT    
2   from            O               O                 Y       nights         from           IN      prep    
3   15th            B-date_from     B-date_from       Y       from           15th           NN      pobj    
4   of              I-date_from     I-date_to            N    15th           of             IN      prep    
5   October         I-date_from     B-date_from          N    of             October        NNP     pobj    
6   ?               O               O                 Y       nights         ?              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (0, 2): date_period    
  (3, 6): date_from      

predicted spans (incorrectly extracted from BIO tags):
Y (0, 2): date_period
  (3, 5): date_from
  (5, 6): date_from

=============================================================================================

Input: 2 weeks

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   2               B-date_period   I-date               N    weeks          2              CD      nummod  
1   weeks           I-date_period   O                    N    weeks          week           NNS     ROOT    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (0, 2): date_period    

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: 1 adults and 8 children. Saturday to Tuesday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   1               B-adults        B-adults          Y       adults         1              CD      nummod  
1   adults          O               O                 Y       adults         adult          NNS     ROOT    
2   and             O               O                 Y       adults         and            CC      cc      
3   8               B-kids          B-kids            Y       children       8              CD      nummod  
4   children        O               O                 Y       adults         child          NNS     conj    
5   .               O               O                 Y       adults         .              .       punct   
6   Saturday        B-date_from     B-date_from       Y       Saturday       Saturday       NNP     ROOT    
7   to              O               O                 Y       Saturday       to             IN      prep    
8   Tuesday         B-date_to       B-date_to         Y       to             Tuesday        NNP     pobj    

annotated spans:
Y (0, 1): adults         
Y (3, 4): kids           
Y (6, 7): date_from      
Y (8, 9): date_to        

predicted spans:
Y (0, 1): adults
Y (3, 4): kids
Y (6, 7): date_from
Y (8, 9): date_to

=============================================================================================

Input: our two kids and I

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   our             O               O                 Y       kids           our            PRP$    poss    
1   two             B-kids          B-kids            Y       kids           two            CD      nummod  
2   kids            O               O                 Y       kids           kid            NNS     ROOT    
3   and             O               O                 Y       kids           and            CC      cc      
4   I               B-adults        O                    N    kids           I              PRP     conj    

annotated spans:
Y (1, 2): kids           
  (4, 5): adults         

predicted spans:
Y (1, 2): kids

=============================================================================================

Input: I'd like to arrive on Wednesday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       like           I              PRP     nsubj   
1   'd              O               O                 Y       like           would          MD      aux     
2   like            O               O                 Y       like           like           VB      ROOT    
3   to              O               O                 Y       arrive         to             TO      aux     
4   arrive          O               O                 Y       like           arrive         VB      xcomp   
5   on              O               O                 Y       arrive         on             IN      prep    
6   Wednesday       B-date_from     B-date_from       Y       on             Wednesday      NNP     pobj    

annotated spans:
Y (6, 7): date_from      

predicted spans:
Y (6, 7): date_from

=============================================================================================

Input: leaving on the 12th, arriving on the 10th

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   leaving         O               O                 Y       leaving        leave          VBG     ROOT    
1   on              O               O                 Y       leaving        on             IN      prep    
2   the             O               O                 Y       12th           the            DT      det     
3   12th            B-date_to       I-date_from          N    on             12th           NN      pobj    
4   ,               O               O                 Y       leaving        ,              ,       punct   
5   arriving        O               O                 Y       leaving        arrive         VBG     advcl   
6   on              O               O                 Y       arriving       on             IN      prep    
7   the             O               O                 Y       10th           the            DT      det     
8   10th            B-date_from     B-date_from       Y       on             10th           JJ      pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (3, 4): date_to        
Y (8, 9): date_from      

predicted spans (incorrectly extracted from BIO tags):
Y (8, 9): date_from

=============================================================================================

Input: I'm leaving on Thursday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       leaving        I              PRP     nsubj   
1   'm              O               O                 Y       leaving        be             VBP     aux     
2   leaving         O               O                 Y       leaving        leave          VBG     ROOT    
3   on              O               O                 Y       leaving        on             IN      prep    
4   Thursday        B-date_to       B-date_from          N    leaving        Thursday       NNP     npadvmod

annotated spans:
  (4, 5): date_to        

predicted spans:
  (4, 5): date_from

=============================================================================================

Input: Something's wrong with the shower, only cold water since 25 past 17 afternoon today.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Something       O               O                 Y       wrong          something      NN      poss    
1   's              O               O                 Y       Something      's             POS     case    
2   wrong           O               O                 Y       wrong          wrong          NN      ROOT    
3   with            O               O                 Y       wrong          with           IN      prep    
4   the             O               O                 Y       shower         the            DT      det     
5   shower          O               O                 Y       with           shower         NN      pobj    
6   ,               O               O                 Y       shower         ,              ,       punct   
7   only            O               O                 Y       water          only           RB      advmod  
8   cold            O               O                 Y       water          cold           JJ      amod    
9   water           O               O                 Y       shower         water          NN      appos   
10  since           O               O                 Y       wrong          since          IN      prep    
11  25              B-time_from     B-time               N    afternoon      25             CD      nummod  
12  past            I-time_from     I-time               N    afternoon      past           JJ      amod    
13  17              I-time_from     I-time               N    afternoon      17             CD      nummod  
14  afternoon       I-time_from     I-date_from          N    since          afternoon      NN      pobj    
15  today           B-date          B-date            Y       wrong          today          NN      npadvmod
16  .               O               O                 Y       wrong          .              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (11, 15): time_from      
Y (15, 16): date           

predicted spans (incorrectly extracted from BIO tags):
  (11, 15): time
Y (15, 16): date

=============================================================================================

Input: I just wanted to confirm the booking and that's all, thanks and bye-bye!

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       wanted         I              PRP     nsubj   
1   just            O               O                 Y       wanted         just           RB      advmod  
2   wanted          O               O                 Y       wanted         want           VBD     ROOT    
3   to              O               O                 Y       confirm        to             TO      aux     
4   confirm         O               O                 Y       wanted         confirm        VB      xcomp   
5   the             O               O                 Y       booking        the            DT      det     
6   booking         O               O                 Y       confirm        booking        NN      dobj    
7   and             O               O                 Y       wanted         and            CC      cc      
8   that            O               O                 Y       's             that           DT      nsubj   
9   's              O               O                 Y       wanted         be             VBZ     conj    
10  all             O               O                 Y       's             all            DT      attr    
11  ,               O               O                 Y       's             ,              ,       punct   
12  thanks          O               O                 Y       's             thank          NNS     npadvmod
13  and             O               O                 Y       thanks         and            CC      cc      
14  bye             O               O                 Y       thanks         bye            UH      conj    
15  -               O               O                 Y       bye            -              UH      intj    
16  bye             O               O                 Y       thanks         bye            NN      conj    
17  !               O               O                 Y       's             !              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: the room was supposedly cleaned but this is still pretty dirty

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   the             O               O                 Y       room           the            DT      det     
1   room            O               O                 Y       cleaned        room           NN      nsubjpass
2   was             O               O                 Y       cleaned        be             VBD     auxpass 
3   supposedly      O               O                 Y       cleaned        supposedly     RB      advmod  
4   cleaned         O               O                 Y       cleaned        clean          VBN     ROOT    
5   but             O               O                 Y       cleaned        but            CC      cc      
6   this            O               O                 Y       is             this           DT      nsubj   
7   is              O               O                 Y       cleaned        be             VBZ     conj    
8   still           O               O                 Y       is             still          RB      advmod  
9   pretty          O               O                 Y       dirty          pretty         RB      advmod  
10  dirty           O               O                 Y       is             dirty          JJ      acomp   

annotated spans:

predicted spans:

=============================================================================================

Input: how much time does a spa session last?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   how             O               O                 Y       much           how            WRB     advmod  
1   much            O               O                 Y       time           much           JJ      amod    
2   time            O               O                 Y       last           time           NN      npadvmod
3   does            O               O                 Y       last           do             VBZ     aux     
4   a               O               O                 Y       session        a              DT      det     
5   spa             O               O                 Y       session        spa            NN      compound
6   session         O               O                 Y       last           session        NN      nsubj   
7   last            O               O                 Y       last           last           JJ      ROOT    
8   ?               O               O                 Y       last           ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: can I go to the gym if I am in a wheelchair?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   can             O               O                 Y       go             can            MD      aux     
1   I               O               O                 Y       go             I              PRP     nsubj   
2   go              O               O                 Y       go             go             VB      ROOT    
3   to              O               O                 Y       go             to             IN      prep    
4   the             O               O                 Y       gym            the            DT      det     
5   gym             O               O                 Y       to             gym            NN      pobj    
6   if              O               O                 Y       am             if             IN      mark    
7   I               O               O                 Y       am             I              PRP     nsubj   
8   am              O               O                 Y       go             be             VBP     advcl   
9   in              O               O                 Y       am             in             IN      prep    
10  a               O               O                 Y       wheelchair     a              DT      det     
11  wheelchair      O               O                 Y       in             wheelchair     NN      pobj    
12  ?               O               O                 Y       go             ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: i have doubts about my check in date

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y       have           I              PRP     nsubj   
1   have            O               O                 Y       have           have           VBP     ROOT    
2   doubts          O               O                 Y       have           doubt          NNS     dobj    
3   about           O               O                 Y       doubts         about          IN      prep    
4   my              O               O                 Y       check          my             PRP$    poss    
5   check           O               O                 Y       about          check          NN      pobj    
6   in              O               O                 Y       have           in             IN      prep    
7   date            O               O                 Y       in             date           NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: Please tell me that one more time

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Please          O               O                 Y       tell           please         UH      intj    
1   tell            O               O                 Y       tell           tell           VB      ROOT    
2   me              O               O                 Y       tell           I              PRP     dobj    
3   that            O               O                 Y       time           that           IN      det     
4   one             O               O                 Y       time           one            CD      nummod  
5   more            O               O                 Y       time           more           JJR     amod    
6   time            O               O                 Y       tell           time           NN      npadvmod

annotated spans:

predicted spans:

=============================================================================================

Input: Hello, I am calling due to some issues with online check in.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Hello           O               O                 Y       calling        hello          UH      intj    
1   ,               O               O                 Y       calling        ,              ,       punct   
2   I               O               O                 Y       calling        I              PRP     nsubj   
3   am              O               O                 Y       calling        be             VBP     aux     
4   calling         O               O                 Y       calling        call           VBG     ROOT    
5   due             O               O                 Y       calling        due            JJ      prep    
6   to              O               O                 Y       due            to             IN      prep    
7   some            O               O                 Y       issues         some           DT      det     
8   issues          O               O                 Y       to             issue          NNS     pobj    
9   with            O               O                 Y       issues         with           IN      prep    
10  online          O               O                 Y       check          online         JJ      amod    
11  check           O               O                 Y       with           check          NN      pobj    
12  in              O               O                 Y       calling        in             RP      prep    
13  .               O               O                 Y       calling        .              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I need to speak to someone at the restaurant.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       need           I              PRP     nsubj   
1   need            O               O                 Y       need           need           VBP     ROOT    
2   to              O               O                 Y       speak          to             TO      aux     
3   speak           O               O                 Y       need           speak          VB      xcomp   
4   to              O               O                 Y       speak          to             IN      prep    
5   someone         O               O                 Y       to             someone        NN      pobj    
6   at              O               O                 Y       someone        at             IN      prep    
7   the             O               O                 Y       restaurant     the            DT      det     
8   restaurant      O               O                 Y       at             restaurant     NN      pobj    
9   .               O               O                 Y       need           .              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I'll arrive earlier than what I thought, can I check in already at 12:45 p.m.?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       arrive         I              PRP     nsubj   
1   'll             O               O                 Y       arrive         'll            MD      aux     
2   arrive          O               O                 Y       check          arrive         VB      ccomp   
3   earlier         O               O                 Y       arrive         early          RBR     advmod  
4   than            O               O                 Y       earlier        than           IN      prep    
5   what            O               O                 Y       thought        what           WP      dobj    
6   I               O               O                 Y       thought        I              PRP     nsubj   
7   thought         O               O                 Y       than           think          VBD     pcomp   
8   ,               O               O                 Y       check          ,              ,       punct   
9   can             O               O                 Y       check          can            MD      aux     
10  I               O               O                 Y       check          I              PRP     nsubj   
11  check           O               O                 Y       check          check          VB      ROOT    
12  in              O               O                 Y       check          in             RP      prt     
13  already         O               O                 Y       check          already        RB      advmod  
14  at              O               O                 Y       check          at             IN      prep    
15  12:45           B-time          B-time            Y       at             12:45          CD      pobj    
16  p.m.            I-time          I-time            Y       check          p.m.           NN      npadvmod
17  ?               O               O                 Y       check          ?              .       punct   

annotated spans:
Y (15, 17): time           

predicted spans:
Y (15, 17): time

=============================================================================================

Input: when do i need to leave the room my last day?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   when            O               O                 Y       need           when           WRB     advmod  
1   do              O               O                 Y       need           do             VBP     aux     
2   i               O               O                 Y       need           I              PRP     nsubj   
3   need            O               O                 Y       need           need           VB      ROOT    
4   to              O               O                 Y       leave          to             TO      aux     
5   leave           O               O                 Y       need           leave          VB      xcomp   
6   the             O               O                 Y       room           the            DT      det     
7   room            O               O                 Y       leave          room           NN      dobj    
8   my              O               O                 Y       day            my             PRP$    poss    
9   last            O               I-date_period        N    day            last           JJ      amod    
10  day             O               B-date               N    leave          day            NN      npadvmod
11  ?               O               O                 Y       need           ?              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:

predicted spans (incorrectly extracted from BIO tags):
  (10, 11): date

=============================================================================================

Input: I will be late for my 10 to 4 afternoon restaurant reservation, it's dalana palomares

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       be             I              PRP     nsubj   
1   will            O               O                 Y       be             will           MD      aux     
2   be              O               O                 Y       's             be             VB      ccomp   
3   late            O               O                 Y       be             late           JJ      acomp   
4   for             O               O                 Y       late           for            IN      prep    
5   my              O               O                 Y       reservation    my             PRP$    poss    
6   10              B-time          B-time            Y       4              10             CD      quantmod
7   to              I-time          O                    N    4              to             TO      quantmod
8   4               I-time          B-rooms              N    afternoon      4              CD      nummod  
9   afternoon       I-time          I-time            Y       reservation    afternoon      NN      compound
10  restaurant      O               O                 Y       reservation    restaurant     NN      compound
11  reservation     O               O                 Y       for            reservation    NN      pobj    
12  ,               O               O                 Y       's             ,              ,       punct   
13  it              O               O                 Y       's             it             PRP     nsubj   
14  's              O               O                 Y       's             be             VBZ     ROOT    
15  dalana          B-person_name   O                    N    palomares      dalana         NNP     compound
16  palomares       I-person_name   O                    N    's             palomare       NNS     attr    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (6, 10): time           
  (15, 17): person_name    

predicted spans (incorrectly extracted from BIO tags):
  (6, 7): time
  (8, 10): rooms

=============================================================================================

Input: yep, book it under jon!

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   yep             O               O                 Y       book           yep            UH      intj    
1   ,               O               O                 Y       book           ,              ,       punct   
2   book            O               O                 Y       book           book           NN      ROOT    
3   it              O               O                 Y       book           it             PRP     dobj    
4   under           O               O                 Y       book           under          IN      prep    
5   jon             O               O                 Y       under          jon            NN      pobj    
6   !               O               O                 Y       book           !              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: i don't have a booking yet

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y       have           I              PRP     nsubj   
1   do              O               O                 Y       have           do             VBP     aux     
2   n't             O               O                 Y       have           n't            RB      neg     
3   have            O               O                 Y       have           have           VB      ROOT    
4   a               O               O                 Y       booking        a              DT      det     
5   booking         O               O                 Y       have           booking        NN      dobj    
6   yet             O               O                 Y       have           yet            RB      advmod  

annotated spans:

predicted spans:

=============================================================================================

Input: i want to swim

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y       want           I              PRP     nsubj   
1   want            O               O                 Y       want           want           VBP     ROOT    
2   to              O               O                 Y       swim           to             TO      aux     
3   swim            O               O                 Y       want           swim           VB      xcomp   

annotated spans:

predicted spans:

=============================================================================================

Input: I'll be arriving with my 4 dogs. Can they enter the premises?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       arriving       I              PRP     nsubj   
1   'll             O               O                 Y       arriving       'll            MD      aux     
2   be              O               O                 Y       arriving       be             VB      aux     
3   arriving        O               O                 Y       arriving       arrive         VBG     ROOT    
4   with            O               O                 Y       arriving       with           IN      prep    
5   my              O               O                 Y       dogs           my             PRP$    poss    
6   4               B-number        B-adults             N    dogs           4              CD      nummod  
7   dogs            O               O                 Y       with           dog            NNS     pobj    
8   .               O               O                 Y       arriving       .              .       punct   
9   Can             O               O                 Y       enter          can            MD      aux     
10  they            O               O                 Y       enter          they           PRP     nsubj   
11  enter           O               O                 Y       enter          enter          VB      ROOT    
12  the             O               O                 Y       premises       the            DT      det     
13  premises        O               O                 Y       enter          premise        NNS     dobj    
14  ?               O               O                 Y       enter          ?              .       punct   

annotated spans:
  (6, 7): number         

predicted spans:
  (6, 7): adults

=============================================================================================

Input: no no not right now

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   no              O               O                 Y       no             no             UH      ROOT    
1   no              O               O                 Y       no             no             UH      intj    
2   not             O               O                 Y       right          not            RB      neg     
3   right           O               O                 Y       now            right          RB      advmod  
4   now             O               O                 Y       no             now            RB      advmod  

annotated spans:

predicted spans:

=============================================================================================

Input: internet is not working

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   internet        O               O                 Y       working        internet       NN      nsubj   
1   is              O               O                 Y       working        be             VBZ     aux     
2   not             O               O                 Y       working        not            RB      neg     
3   working         O               O                 Y       working        work           VBG     ROOT    

annotated spans:

predicted spans:

=============================================================================================

Input: Double room within jacuzzi for a couple. Check in 6th of Sep and check out 22nd of Sep

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Double          B-rooms         B-rooms           Y       room           double         JJ      amod    
1   room            I-rooms         O                    N    room           room           NN      ROOT    
2   within          O               O                 Y       room           within         IN      prep    
3   jacuzzi         O               O                 Y       within         jacuzzi        NNP     pobj    
4   for             O               O                 Y       room           for            IN      prep    
5   a               B-adults        O                    N    couple         a              DT      det     
6   couple          I-adults        I-date_to            N    for            couple         NN      pobj    
7   .               O               O                 Y       room           .              .       punct   
8   Check           O               O                 Y       Check          check          VB      ROOT    
9   in              O               O                 Y       Check          in             IN      prep    
10  6th             B-date_from     B-date_from       Y       in             6th            NN      pobj    
11  of              I-date_from     O                    N    6th            of             IN      prep    
12  Sep             I-date_from     O                    N    of             Sep            NNP     pobj    
13  and             O               O                 Y       Check          and            CC      cc      
14  check           O               O                 Y       Check          check          VB      conj    
15  out             O               O                 Y       check          out            RP      prt     
16  22nd            B-date_to       B-date_from          N    check          22nd           NN      dobj    
17  of              I-date_to       I-date_from          N    22nd           of             IN      prep    
18  Sep             I-date_to       O                    N    of             Sep            NNP     pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (0, 2): rooms          
  (5, 7): adults         
  (10, 13): date_from      
  (16, 19): date_to        

predicted spans (incorrectly extracted from BIO tags):
  (0, 1): rooms
  (10, 11): date_from
  (16, 18): date_from

=============================================================================================

Input: is it possible to reserve a treadmill in the gym?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   is              O               O                 Y       is             be             VBZ     ROOT    
1   it              O               O                 Y       is             it             PRP     nsubj   
2   possible        O               O                 Y       is             possible       JJ      acomp   
3   to              O               O                 Y       reserve        to             TO      aux     
4   reserve         O               O                 Y       is             reserve        VB      xcomp   
5   a               O               O                 Y       treadmill      a              DT      det     
6   treadmill       O               O                 Y       reserve        treadmill      NN      dobj    
7   in              O               O                 Y       reserve        in             IN      prep    
8   the             O               O                 Y       gym            the            DT      det     
9   gym             O               O                 Y       in             gym            NN      pobj    
10  ?               O               O                 Y       is             ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: whats the price of skincare treatments?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   what            O               O                 Y       s              what           WP      attr    
1   s               O               O                 Y       s              s              VBZ     ROOT    
2   the             O               O                 Y       price          the            DT      det     
3   price           O               O                 Y       s              price          NN      nsubj   
4   of              O               O                 Y       price          of             IN      prep    
5   skincare        O               O                 Y       treatments     skincare       NN      compound
6   treatments      O               O                 Y       of             treatment      NNS     pobj    
7   ?               O               O                 Y       s              ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: it will be 7

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   it              O               O                 Y       be             it             PRP     nsubj   
1   will            O               O                 Y       be             will           MD      aux     
2   be              O               O                 Y       be             be             VB      ROOT    
3   7               B-number        B-people             N    be             7              CD      attr    

annotated spans:
  (3, 4): number         

predicted spans:
  (3, 4): people

=============================================================================================

Input: Lost property

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Lost            O               I-kids               N    property       lose           VBN     amod    
1   property        O               O                 Y       property       property       NN      ROOT    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: I might pick up a rental car, do you have parking on site

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       pick           I              PRP     nsubj   
1   might           O               O                 Y       pick           might          MD      aux     
2   pick            O               O                 Y       have           pick           VB      ccomp   
3   up              O               O                 Y       pick           up             RP      prt     
4   a               O               O                 Y       car            a              DT      det     
5   rental          O               O                 Y       car            rental         JJ      amod    
6   car             O               O                 Y       pick           car            NN      dobj    
7   ,               O               O                 Y       have           ,              ,       punct   
8   do              O               O                 Y       have           do             VBP     aux     
9   you             O               O                 Y       have           you            PRP     nsubj   
10  have            O               O                 Y       have           have           VB      ROOT    
11  parking         O               O                 Y       have           parking        NN      dobj    
12  on              O               O                 Y       parking        on             IN      prep    
13  site            O               O                 Y       on             site           NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I want to stay tomorrow night

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       want           I              PRP     nsubj   
1   want            O               O                 Y       want           want           VBP     ROOT    
2   to              O               O                 Y       stay           to             TO      aux     
3   stay            O               O                 Y       want           stay           VB      xcomp   
4   tomorrow        B-date_from     B-date               N    night          tomorrow       NN      compound
5   night           B-time_period   B-time_period     Y       stay           night          NN      npadvmod

annotated spans:
  (4, 5): date_from      
Y (5, 6): time_period    

predicted spans:
  (4, 5): date
Y (5, 6): time_period

=============================================================================================

Input: i cant make it to my restaurant booking at 2:10 night

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y       make           I              PRP     nsubj   
1   ca              O               O                 Y       make           ca             MD      aux     
2   nt              O               O                 Y       make           nt             RB      neg     
3   make            O               O                 Y       make           make           VB      ROOT    
4   it              O               O                 Y       make           it             PRP     dobj    
5   to              O               O                 Y       make           to             IN      prep    
6   my              O               O                 Y       booking        my             PRP$    poss    
7   restaurant      O               O                 Y       booking        restaurant     NN      compound
8   booking         O               O                 Y       to             booking        NN      pobj    
9   at              O               O                 Y       make           at             IN      prep    
10  2:10            B-time          B-date_from          N    night          2:10           CD      nummod  
11  night           I-time          I-time_to            N    at             night          NN      pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (10, 12): time           

predicted spans (incorrectly extracted from BIO tags):
  (10, 12): date_from

=============================================================================================

Input: please just cancel that booking for murad as I got ill.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   please          O               O                 Y       cancel         please         UH      intj    
1   just            O               O                 Y       cancel         just           RB      advmod  
2   cancel          O               O                 Y       cancel         cancel         VB      ROOT    
3   that            O               O                 Y       booking        that           IN      det     
4   booking         O               O                 Y       cancel         booking        NN      dobj    
5   for             O               O                 Y       booking        for            IN      prep    
6   murad           B-person_name   O                    N    for            murad          NN      pobj    
7   as              O               O                 Y       got            as             IN      mark    
8   I               O               O                 Y       got            I              PRP     nsubj   
9   got             O               O                 Y       cancel         get            VBD     advcl   
10  ill             O               O                 Y       got            ill            JJ      acomp   
11  .               O               O                 Y       cancel         .              .       punct   

annotated spans:
  (6, 7): person_name    

predicted spans:

=============================================================================================

Input: i need to change the time of my makeup service tomorrow

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y       need           I              PRP     nsubj   
1   need            O               O                 Y       need           need           VBP     ROOT    
2   to              O               O                 Y       change         to             TO      aux     
3   change          O               O                 Y       need           change         VB      xcomp   
4   the             O               O                 Y       time           the            DT      det     
5   time            O               O                 Y       change         time           NN      dobj    
6   of              O               O                 Y       time           of             IN      prep    
7   my              O               O                 Y       service        my             PRP$    poss    
8   makeup          O               O                 Y       service        makeup         NN      compound
9   service         O               O                 Y       of             service        NN      pobj    
10  tomorrow        B-date          B-date            Y       need           tomorrow       NN      npadvmod

annotated spans:
Y (10, 11): date           

predicted spans:
Y (10, 11): date

=============================================================================================

Input: How do I order caesar salad

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   How             O               O                 Y       order          how            WRB     advmod  
1   do              O               O                 Y       order          do             VBP     aux     
2   I               O               O                 Y       order          I              PRP     nsubj   
3   order           O               O                 Y       order          order          VB      ROOT    
4   caesar          O               O                 Y       salad          caesar         NNP     compound
5   salad           O               O                 Y       order          salad          VBD     ccomp   

annotated spans:

predicted spans:

=============================================================================================

Input: we are in our room and hungry

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   we              O               O                 Y       are            we             PRP     nsubj   
1   are             O               O                 Y       are            be             VBP     ROOT    
2   in              O               O                 Y       are            in             IN      prep    
3   our             O               O                 Y       room           our            PRP$    poss    
4   room            O               O                 Y       in             room           NN      pobj    
5   and             O               O                 Y       are            and            CC      cc      
6   hungry          O               O                 Y       are            hungry         JJ      conj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a booking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       have           I              PRP     nsubj   
1   have            O               O                 Y       have           have           VBP     ROOT    
2   a               O               O                 Y       booking        a              DT      det     
3   booking         O               O                 Y       have           booking        NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: 6 15 I have a table booking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   6               B-time          B-time            Y       15             6              CD      compound
1   15              I-time          O                    N    have           15             CD      npadvmod
2   I               O               O                 Y       have           I              PRP     nsubj   
3   have            O               O                 Y       have           have           VBP     ROOT    
4   a               O               O                 Y       booking        a              DT      det     
5   table           O               O                 Y       booking        table          NN      compound
6   booking         O               O                 Y       have           booking        NN      dobj    

annotated spans:
  (0, 2): time           

predicted spans:
  (0, 1): time

=============================================================================================

Input: I need a dinning reservation for 5 people on March 13th at 9 pm

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       need           I              PRP     nsubj   
1   need            O               O                 Y       need           need           VBP     ROOT    
2   a               O               O                 Y       reservation    a              DT      det     
3   dinning         O               O                 Y       reservation    dinning        NN      amod    
4   reservation     O               O                 Y       need           reservation    NN      dobj    
5   for             O               O                 Y       reservation    for            IN      prep    
6   5               B-people        B-people          Y       people         5              CD      nummod  
7   people          O               O                 Y       for            people         NNS     pobj    
8   on              O               O                 Y       reservation    on             IN      prep    
9   March           B-date          B-date_from          N    13th           March          NNP     compound
10  13th            I-date          I-date_to            N    on             13th           NN      pobj    
11  at              O               O                 Y       need           at             IN      prep    
12  9               B-time          B-time            Y       pm             9              CD      nummod  
13  pm              I-time          O                    N    at             pm             NN      pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (6, 7): people         
  (9, 11): date           
  (12, 14): time           

predicted spans (incorrectly extracted from BIO tags):
Y (6, 7): people
  (9, 11): date_from
  (12, 13): time

=============================================================================================

Input: I just want to change some details of my hotel booking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       want           I              PRP     nsubj   
1   just            O               O                 Y       want           just           RB      advmod  
2   want            O               O                 Y       want           want           VBP     ROOT    
3   to              O               O                 Y       change         to             TO      aux     
4   change          O               O                 Y       want           change         VB      xcomp   
5   some            O               O                 Y       details        some           DT      det     
6   details         O               O                 Y       change         detail         NNS     dobj    
7   of              O               O                 Y       details        of             IN      prep    
8   my              O               O                 Y       booking        my             PRP$    poss    
9   hotel           O               O                 Y       booking        hotel          NN      compound
10  booking         O               O                 Y       of             booking        NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I want to change one

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       want           I              PRP     nsubj   
1   want            O               O                 Y       want           want           VBP     ROOT    
2   to              O               O                 Y       change         to             TO      aux     
3   change          O               O                 Y       want           change         VB      xcomp   
4   one             O               O                 Y       change         one            CD      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: We would like one family room for four from Thursday until Thursday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   We              O               O                 Y       like           we             PRP     nsubj   
1   would           O               O                 Y       like           would          MD      aux     
2   like            O               O                 Y       like           like           VB      ROOT    
3   one             B-rooms         B-rooms           Y       room           one            CD      nummod  
4   family          O               O                 Y       room           family         NN      compound
5   room            O               I-rooms              N    like           room           NN      dobj    
6   for             O               O                 Y       room           for            IN      prep    
7   four            B-people        B-time               N    for            four           CD      pobj    
8   from            O               O                 Y       room           from           IN      prep    
9   Thursday        B-date_from     B-date_from       Y       from           Thursday       NNP     pobj    
10  until           O               O                 Y       like           until          IN      prep    
11  Thursday        B-date_to       B-date_to         Y       until          Thursday       NNP     pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (3, 4): rooms          
  (7, 8): people         
Y (9, 10): date_from      
Y (11, 12): date_to        

predicted spans (incorrectly extracted from BIO tags):
Y (3, 4): rooms
  (7, 8): time
Y (9, 10): date_from
Y (11, 12): date_to

=============================================================================================

Input: I'd like to make a reservation for 5 people from Sunday 10 July

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       like           I              PRP     nsubj   
1   'd              O               O                 Y       like           would          MD      aux     
2   like            O               O                 Y       like           like           VB      ROOT    
3   to              O               O                 Y       make           to             TO      aux     
4   make            O               O                 Y       like           make           VB      xcomp   
5   a               O               O                 Y       reservation    a              DT      det     
6   reservation     O               O                 Y       make           reservation    NN      dobj    
7   for             O               O                 Y       reservation    for            IN      prep    
8   5               B-people        B-people          Y       people         5              CD      nummod  
9   people          O               O                 Y       for            people         NNS     pobj    
10  from            O               O                 Y       make           from           IN      prep    
11  Sunday          B-date_from     B-date_from       Y       from           Sunday         NNP     pobj    
12  10              I-date_from     I-date               N    Sunday         10             CD      nummod  
13  July            I-date_from     I-date               N    like           July           NNP     npadvmod

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (8, 9): people         
Y (11, 14): date_from      

predicted spans (incorrectly extracted from BIO tags):
Y (8, 9): people
Y (11, 14): date_from

=============================================================================================

Input: 18th of Nov

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   18th            B-date          O                    N    18th           18th           NN      ROOT    
1   of              I-date          I-date_from          N    18th           of             IN      prep    
2   Nov             I-date          I-date_to            N    of             Nov            NNP     pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (0, 3): date           

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: One bedroom, 2 adults and one minor child.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   One             B-rooms         B-adults             N    bedroom        one            CD      nummod  
1   bedroom         O               O                 Y       bedroom        bedroom        NN      ROOT    
2   ,               O               O                 Y       bedroom        ,              ,       punct   
3   2               B-adults        B-adults          Y       adults         2              CD      nummod  
4   adults          O               O                 Y       bedroom        adult          NNS     appos   
5   and             O               O                 Y       adults         and            CC      cc      
6   one             B-kids          B-kids            Y       child          one            CD      nummod  
7   minor           O               O                 Y       child          minor          JJ      amod    
8   child           O               O                 Y       adults         child          NN      conj    
9   .               O               O                 Y       bedroom        .              .       punct   

annotated spans:
  (0, 1): rooms          
Y (3, 4): adults         
Y (6, 7): kids           

predicted spans:
  (0, 1): adults
Y (3, 4): adults
Y (6, 7): kids

=============================================================================================

Input: I would like to book a hotel for 2 nights for 6 in three rooms for Friday to Sunday so we can go drinking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       like           I              PRP     nsubj   
1   would           O               O                 Y       like           would          MD      aux     
2   like            O               O                 Y       like           like           VB      ROOT    
3   to              O               O                 Y       book           to             TO      aux     
4   book            O               O                 Y       like           book           VB      xcomp   
5   a               O               O                 Y       hotel          a              DT      det     
6   hotel           O               O                 Y       book           hotel          NN      dobj    
7   for             O               O                 Y       book           for            IN      prep    
8   2               B-date_period   B-date_period     Y       nights         2              CD      nummod  
9   nights          I-date_period   I-date_period     Y       for            night          NNS     pobj    
10  for             O               O                 Y       book           for            IN      prep    
11  6               O               B-people             N    for            6              CD      pobj    
12  in              O               O                 Y       6              in             IN      prep    
13  three           B-rooms         O                    N    rooms          three          CD      nummod  
14  rooms           O               O                 Y       in             room           NNS     pobj    
15  for             O               O                 Y       book           for            IN      prep    
16  Friday          B-date_from     B-date_from       Y       for            Friday         NNP     pobj    
17  to              O               I-date               N    book           to             IN      prep    
18  Sunday          B-date_to       B-date_to         Y       to             Sunday         NNP     pobj    
19  so              O               O                 Y       go             so             IN      mark    
20  we              O               O                 Y       go             we             PRP     nsubj   
21  can             O               O                 Y       go             can            MD      aux     
22  go              O               O                 Y       like           go             VB      advcl   
23  drinking        O               O                 Y       go             drink          VBG     xcomp   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (8, 10): date_period    
  (13, 14): rooms          
  (16, 17): date_from      
Y (18, 19): date_to        

predicted spans (incorrectly extracted from BIO tags):
Y (8, 10): date_period
  (11, 12): people
  (16, 18): date_from
Y (18, 19): date_to

=============================================================================================

Input: I would like to stay for a fortnight in the cheapest room you have

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       like           I              PRP     nsubj   
1   would           O               O                 Y       like           would          MD      aux     
2   like            O               O                 Y       like           like           VB      ROOT    
3   to              O               O                 Y       stay           to             TO      aux     
4   stay            O               O                 Y       like           stay           VB      xcomp   
5   for             O               O                 Y       stay           for            IN      prep    
6   a               B-date_period   O                    N    fortnight      a              DT      det     
7   fortnight       I-date_period   O                    N    for            fortnight      NN      pobj    
8   in              O               O                 Y       stay           in             IN      prep    
9   the             O               O                 Y       room           the            DT      det     
10  cheapest        O               O                 Y       room           cheap          JJS     amod    
11  room            O               I-rooms              N    in             room           NN      pobj    
12  you             O               O                 Y       have           you            PRP     nsubj   
13  have            O               O                 Y       like           have           VBP     ccomp   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (6, 8): date_period    

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: I would to book a weekend away for myself and my husband for the 29 May please.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y       would          I              PRP     nsubj   
1   would           O               O                 Y       would          would          MD      ROOT    
2   to              O               O                 Y       book           to             TO      aux     
3   book            O               O                 Y       would          book           VB      xcomp   
4   a               B-date_period   B-rooms              N    weekend        a              DT      det     
5   weekend         I-date_period   B-time_period        N    away           weekend        NN      npadvmod
6   away            O               O                 Y       book           away           RB      advmod  
7   for             O               O                 Y       away           for            IN      prep    
8   myself          B-adults        B-adults          Y       for            myself         PRP     pobj    
9   and             I-adults        I-adults          Y       myself         and            CC      cc      
10  my              I-adults        I-adults          Y       husband        my             PRP$    poss    
11  husband         I-adults        I-adults          Y       myself         husband        NN      conj    
12  for             O               O                 Y       book           for            IN      prep    
13  the             O               O                 Y       May            the            DT      det     
14  29              B-date_from     B-kids               N    May            29             CD      nummod  
15  May             I-date_from     O                    N    please         May            NNP     compound
16  please          O               O                 Y       book           please         UH      intj    
17  .               O               O                 Y       would          .              .       punct   

annotated spans:
  (4, 6): date_period    
Y (8, 12): adults         
  (14, 16): date_from      

predicted spans:
  (4, 5): rooms
  (5, 6): time_period
Y (8, 12): adults
  (14, 15): kids

=============================================================================================

Input: One night for next Friday the 17th

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   One             B-date_period   B-date_period     Y       night          one            CD      nummod  
1   night           I-date_period   I-date_period     Y       17th           night          NN      npadvmod
2   for             O               O                 Y       night          for            IN      prep    
3   next            O               B-date_to            N    Friday         next           JJ      amod    
4   Friday          B-date_from     I-date               N    for            Friday         NNP     pobj    
5   the             I-date_from     I-date_from       Y       17th           the            DT      det     
6   17th            I-date_from     I-date_from       Y       17th           17th           JJ      ROOT    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (0, 2): date_period    
  (4, 7): date_from      

predicted spans (incorrectly extracted from BIO tags):
Y (0, 2): date_period
  (3, 7): date_to

=============================================================================================

Input: Two nights from Friday 29th

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   Two             B-date_period   B-date_period     Y       nights         two            CD      nummod  
1   nights          I-date_period   I-date_period     Y       nights         night          NNS     ROOT    
2   from            O               O                 Y       nights         from           IN      prep    
3   Friday          B-date_from     B-date_from       Y       29th           Friday         NNP     compound
4   29th            I-date_from     I-date_from       Y       from           29th           NN      pobj    

annotated spans:
Y (0, 2): date_period    
Y (3, 5): date_from      

predicted spans:
Y (0, 2): date_period
Y (3, 5): date_from

=============================================================================================

Input: two little humans

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   two             B-kids          B-adults             N    humans         two            CD      nummod  
1   little          O               O                 Y       humans         little         JJ      amod    
2   humans          O               O                 Y       humans         human          NNS     ROOT    

annotated spans:
  (0, 1): kids           

predicted spans:
  (0, 1): adults

=============================================================================================

Input: my husband and I will be coming with our three sons

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   my              B-adults        B-adults          Y       husband        my             PRP$    poss    
1   husband         I-adults        I-adults          Y       coming         husband        NN      nsubj   
2   and             I-adults        I-adults          Y       husband        and            CC      cc      
3   I               I-adults        O                    N    husband        I              PRP     conj    
4   will            O               O                 Y       coming         will           MD      aux     
5   be              O               O                 Y       coming         be             VB      aux     
6   coming          O               O                 Y       coming         come           VBG     ROOT    
7   with            O               O                 Y       coming         with           IN      prep    
8   our             O               O                 Y       sons           our            PRP$    poss    
9   three           B-kids          B-kids            Y       sons           three          CD      nummod  
10  sons            O               O                 Y       with           son            NNS     pobj    

annotated spans:
  (0, 4): adults         
Y (9, 10): kids           

predicted spans:
  (0, 3): adults
Y (9, 10): kids

=============================================================================================

Input: myself only

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   myself          B-adults        O                    N    myself         myself         PRP     ROOT    
1   only            O               O                 Y       myself         only           RB      advmod  

annotated spans:
  (0, 1): adults         

predicted spans:

=============================================================================================

Input: 7th to 21st of the month

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   7th             B-date_from     O                    N    7th            7th            JJ      ROOT    
1   to              O               O                 Y       7th            to             IN      prep    
2   21st            B-date_to       B-date_to         Y       to             21st           NN      pobj    
3   of              I-date_to       O                    N    21st           of             IN      prep    
4   the             I-date_to       O                    N    month          the            DT      det     
5   month           I-date_to       O                    N    of             month          NN      pobj    

annotated spans:
  (0, 1): date_from      
  (2, 6): date_to        

predicted spans:
  (2, 3): date_to

=============================================================================================

Input: until the 2nd

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  head           lemma_         tag_    dep_    
---------------------------------------------------------------------------  -------------------------------
0   until           O               O                 Y       until          until          IN      ROOT    
1   the             O               O                 Y       2nd            the            DT      det     
2   2nd             B-date_to       B-date_from          N    until          2nd            JJ      pobj    

annotated spans:
  (2, 3): date_to        

predicted spans:
  (2, 3): date_from

=============================================================================================


Classification report for BIO tags:

               precision    recall  f1-score   support

     B-adults       0.60      0.67      0.63         9
       B-date       0.62      0.62      0.62         8
  B-date_from       0.57      0.65      0.60        20
B-date_period       1.00      0.67      0.80         9
    B-date_to       0.67      0.36      0.47        11
       B-kids       0.71      0.83      0.77         6
     B-number       0.00      0.00      0.00         3
     B-people       0.60      0.75      0.67         4
B-person_name       0.50      0.25      0.33         4
      B-rooms       0.38      0.33      0.35         9
       B-time       0.71      0.83      0.77         6
  B-time_from       0.00      0.00      0.00         1
B-time_period       0.33      0.33      0.33         3
     I-adults       0.83      0.62      0.71         8
       I-date       0.17      0.20      0.18         5
  I-date_from       0.46      0.40      0.43        15
I-date_period       0.86      0.67      0.75         9
    I-date_to       0.00      0.00      0.00         5
       I-kids       0.00      0.00      0.00         0
     I-number       0.00      0.00      0.00         0
     I-people       0.00      0.00      0.00         0
I-person_name       1.00      0.50      0.67         2
      I-rooms       0.70      0.58      0.64        12
       I-time       0.67      0.36      0.47        11
  I-time_from       0.00      0.00      0.00         3
I-time_period       0.00      0.00      0.00         3

    micro avg       0.58      0.49      0.53       166
    macro avg       0.44      0.37      0.39       166
 weighted avg       0.57      0.49      0.52       166

!!! Classification report for slots is unavailable becausesome predicted BIO tag sequences were malformed !!!
> Reading training data from data\training_data.json...
> Reading validation data from data\validation_data.json...
> Tokenising and annotating raw data with spacy...
> Training logistic_regression model on training data...
> Finished training logistic regression on 7348 tokens
> Predicting tags on validation data...
> Evaluating results on validation data...
Input: I would like to check in the 4 April and check out the Wednesday, thanks

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   would           O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   to              O               O                 Y                check          to             TO      aux     
4   check           O               O                 Y                like           check          VB      xcomp   
5   in              O               O                 Y                check          in             IN      prep    
6   the             O               O                 Y       DATE     April          the            DT      det     
7   4               B-date_from     B-date_from       Y       DATE     April          4              CD      nummod  
8   April           I-date_from     I-date_from       Y       DATE     in             April          NNP     pobj    
9   and             O               O                 Y                check          and            CC      cc      
10  check           O               O                 Y                check          check          VB      conj    
11  out             O               O                 Y                check          out            RP      prt     
12  the             O               O                 Y                Wednesday      the            DT      det     
13  Wednesday       B-date_to       I-date_from          N    DATE     check          Wednesday      NNP     dobj    
14  ,               O               O                 Y                check          ,              ,       punct   
15  thanks          O               O                 Y                like           thank          NNS     npadvmod

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (7, 9): date_from      
  (13, 14): date_to        

predicted spans (incorrectly extracted from BIO tags):
Y (7, 9): date_from

=============================================================================================

Input: I am still waiting for the refund of the room i cancelled

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                waiting        I              PRP     nsubj   
1   am              O               O                 Y                waiting        be             VBP     aux     
2   still           O               O                 Y                waiting        still          RB      advmod  
3   waiting         O               O                 Y                waiting        wait           VBG     ROOT    
4   for             O               O                 Y                waiting        for            IN      prep    
5   the             O               O                 Y                refund         the            DT      det     
6   refund          O               O                 Y                for            refund         NN      pobj    
7   of              O               O                 Y                refund         of             IN      prep    
8   the             B-rooms         O                    N             room           the            DT      det     
9   room            I-rooms         O                    N             of             room           NN      pobj    
10  i               O               O                 Y                cancelled      I              PRP     nsubj   
11  cancelled       O               O                 Y                room           cancel         VBD     relcl   

annotated spans:
  (8, 10): rooms          

predicted spans:

=============================================================================================

Input: what time do the cleaning personel come?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   what            O               O                 Y                time           what           WDT     det     
1   time            O               O                 Y                come           time           NN      dobj    
2   do              O               O                 Y                come           do             VBP     aux     
3   the             O               O                 Y                personel       the            DT      det     
4   cleaning        O               O                 Y                personel       cleaning       NN      compound
5   personel        O               O                 Y                come           personel       NN      nsubj   
6   come            O               O                 Y                come           come           VB      ROOT    
7   ?               O               O                 Y                come           ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: how much does a full body massage last?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   how             O               O                 Y                much           how            WRB     advmod  
1   much            O               O                 Y                last           much           JJ      advmod  
2   does            O               O                 Y                last           do             VBZ     aux     
3   a               O               B-rooms              N             massage        a              DT      det     
4   full            O               O                 Y                massage        full           JJ      amod    
5   body            O               O                 Y                massage        body           NN      compound
6   massage         O               O                 Y                last           massage        NN      nsubj   
7   last            O               O                 Y                last           last           JJ      ROOT    
8   ?               O               O                 Y                last           ?              .       punct   

annotated spans:

predicted spans:
  (3, 4): rooms

=============================================================================================

Input: ok, then I need a wheelchair friendly room

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   ok              O               O                 Y                need           ok             UH      intj    
1   ,               O               O                 Y                need           ,              ,       punct   
2   then            O               O                 Y                need           then           RB      advmod  
3   I               O               O                 Y                need           I              PRP     nsubj   
4   need            O               O                 Y                need           need           VBP     ROOT    
5   a               B-rooms         O                    N             room           a              DT      det     
6   wheelchair      I-rooms         O                    N             friendly       wheelchair     NN      npadvmod
7   friendly        I-rooms         B-person_name        N             room           friendly       JJ      amod    
8   room            I-rooms         I-rooms           Y                need           room           NN      dobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (5, 9): rooms          

predicted spans (incorrectly extracted from BIO tags):
  (7, 9): person_name

=============================================================================================

Input: i lost it, but don't know where

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y                lost           I              PRP     nsubj   
1   lost            O               O                 Y                lost           lose           VBD     ROOT    
2   it              O               O                 Y                lost           it             PRP     dobj    
3   ,               O               O                 Y                lost           ,              ,       punct   
4   but             O               O                 Y                lost           but            CC      cc      
5   do              O               O                 Y                know           do             VBP     aux     
6   n't             O               O                 Y                know           n't            RB      neg     
7   know            O               O                 Y                lost           know           VB      conj    
8   where           O               O                 Y                know           where          WRB     ccomp   

annotated spans:

predicted spans:

=============================================================================================

Input: i lost it, but no idea where

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y                lost           I              PRP     nsubj   
1   lost            O               O                 Y                lost           lose           VBD     ROOT    
2   it              O               O                 Y                lost           it             PRP     dobj    
3   ,               O               O                 Y                lost           ,              ,       punct   
4   but             O               O                 Y                lost           but            CC      cc      
5   no              O               O                 Y                idea           no             DT      det     
6   idea            O               O                 Y                lost           idea           NN      conj    
7   where           O               O                 Y                idea           where          WRB     advmod  

annotated spans:

predicted spans:

=============================================================================================

Input: Goodbye, my virtual friend!

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Goodbye         O               I-adults             N             Goodbye        Goodbye        NNP     ROOT    
1   ,               O               O                 Y                Goodbye        ,              ,       punct   
2   my              O               O                 Y                friend         my             PRP$    poss    
3   virtual         O               O                 Y                friend         virtual        JJ      amod    
4   friend          O               O                 Y                Goodbye        friend         NN      appos   
5   !               O               O                 Y                Goodbye        !              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: hiya there, I need some info about my current booking at your place

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   hiya            O               O                 Y                need           hiya           NNP     advmod  
1   there           O               O                 Y                need           there          RB      advmod  
2   ,               O               O                 Y                need           ,              ,       punct   
3   I               O               O                 Y                need           I              PRP     nsubj   
4   need            O               O                 Y                need           need           VBP     ROOT    
5   some            O               O                 Y                info           some           DT      det     
6   info            O               O                 Y                need           info           NN      dobj    
7   about           O               O                 Y                info           about          IN      prep    
8   my              O               O                 Y                booking        my             PRP$    poss    
9   current         O               O                 Y                booking        current        JJ      amod    
10  booking         O               O                 Y                about          booking        NN      pobj    
11  at              O               O                 Y                need           at             IN      prep    
12  your            O               O                 Y                place          your           PRP$    poss    
13  place           O               O                 Y                at             place          NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I need to speak to someone working at the pool.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                need           I              PRP     nsubj   
1   need            O               O                 Y                need           need           VBP     ROOT    
2   to              O               O                 Y                speak          to             TO      aux     
3   speak           O               O                 Y                need           speak          VB      xcomp   
4   to              O               O                 Y                speak          to             IN      prep    
5   someone         O               O                 Y                to             someone        NN      pobj    
6   working         O               O                 Y                someone        work           VBG     acl     
7   at              O               O                 Y                working        at             IN      prep    
8   the             O               O                 Y                pool           the            DT      det     
9   pool            O               O                 Y                at             pool           NN      pobj    
10  .               O               O                 Y                need           .              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: It will be fewer people today than what I first told you.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   It              O               O                 Y                be             it             PRP     nsubj   
1   will            O               O                 Y                be             will           MD      aux     
2   be              O               O                 Y                be             be             VB      ROOT    
3   fewer           O               O                 Y                people         few            JJR     amod    
4   people          O               O                 Y                be             people         NNS     attr    
5   today           B-date          B-date            Y       DATE     be             today          NN      npadvmod
6   than            O               O                 Y                be             than           IN      prep    
7   what            O               O                 Y                told           what           WP      dative  
8   I               O               O                 Y                told           I              PRP     nsubj   
9   first           O               O                 Y       ORDINAL  told           first          RB      advmod  
10  told            O               O                 Y                than           tell           VBD     pcomp   
11  you             O               O                 Y                told           you            PRP     dobj    
12  .               O               O                 Y                be             .              .       punct   

annotated spans:
Y (5, 6): date           

predicted spans:
Y (5, 6): date

=============================================================================================

Input: when can I do check in very latest?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   when            O               O                 Y                check          when           WRB     advmod  
1   can             O               O                 Y                check          can            MD      aux     
2   I               O               O                 Y                check          I              PRP     nsubj   
3   do              O               O                 Y                check          do             VB      aux     
4   check           O               O                 Y                check          check          VB      ROOT    
5   in              O               O                 Y                check          in             IN      prep    
6   very            O               O                 Y                latest         very           RB      advmod  
7   latest          O               O                 Y                check          late           JJS     advmod  
8   ?               O               O                 Y                check          ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I want to check out, but still leave my car at the parking spot for few more hours.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                check          to             TO      aux     
3   check           O               O                 Y                want           check          VB      xcomp   
4   out             O               O                 Y                check          out            RP      prt     
5   ,               O               O                 Y                want           ,              ,       punct   
6   but             O               O                 Y                want           but            CC      cc      
7   still           O               O                 Y                leave          still          RB      advmod  
8   leave           O               O                 Y                want           leave          VB      conj    
9   my              O               O                 Y                car            my             PRP$    poss    
10  car             O               O                 Y                leave          car            NN      dobj    
11  at              O               O                 Y                leave          at             IN      prep    
12  the             O               O                 Y                spot           the            DT      det     
13  parking         O               O                 Y                spot           parking        NN      compound
14  spot            O               O                 Y                at             spot           NN      pobj    
15  for             O               O                 Y                leave          for            IN      prep    
16  few             B-time_period   O                    N    TIME     hours          few            JJ      amod    
17  more            I-time_period   I-kids               N    TIME     hours          more           JJR     amod    
18  hours           I-time_period   O                    N    TIME     for            hour           NNS     pobj    
19  .               O               O                 Y                want           .              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (16, 19): time_period    

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: I'd like to rebook for a later date, say, Wednesday 26th October

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   'd              O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   to              O               O                 Y                rebook         to             TO      aux     
4   rebook          O               O                 Y                like           rebook         VB      xcomp   
5   for             O               O                 Y                rebook         for            IN      prep    
6   a               O               O                 Y       DATE     date           a              DT      det     
7   later           O               O                 Y       DATE     date           later          JJ      amod    
8   date            O               O                 Y       DATE     for            date           NN      pobj    
9   ,               O               O                 Y                rebook         ,              ,       punct   
10  say             O               B-date_from          N             rebook         say            UH      intj    
11  ,               O               O                 Y                rebook         ,              ,       punct   
12  Wednesday       B-date_from     B-date               N    DATE     26th           Wednesday      NNP     compound
13  26th            I-date_from     I-date_from       Y       DATE     rebook         26th           NN      npadvmod
14  October         I-date_from     I-date_to            N    DATE     like           October        NNP     npadvmod

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (12, 15): date_from      

predicted spans (incorrectly extracted from BIO tags):
  (10, 11): date_from
  (12, 15): date

=============================================================================================

Input: new

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   new             O               O                 Y                new            new            JJ      ROOT    

annotated spans:

predicted spans:

=============================================================================================

Input: Where exactly is the pool?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Where           O               O                 Y                exactly        where          WRB     advmod  
1   exactly         O               O                 Y                is             exactly        RB      advmod  
2   is              O               O                 Y                is             be             VBZ     ROOT    
3   the             O               O                 Y                pool           the            DT      det     
4   pool            O               O                 Y                is             pool           NN      nsubj   
5   ?               O               O                 Y                is             ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I have just one dog I wanted to have in my room, can I make sure that is ok

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                have           I              PRP     nsubj   
1   have            O               O                 Y                make           have           VBP     ccomp   
2   just            O               O                 Y                one            just           RB      advmod  
3   one             O               B-adults             N    CARDINAL dog            one            CD      nummod  
4   dog             O               O                 Y                have           dog            NN      dobj    
5   I               O               O                 Y                wanted         I              PRP     nsubj   
6   wanted          O               O                 Y                dog            want           VBD     relcl   
7   to              O               O                 Y                have           to             TO      aux     
8   have            O               O                 Y                wanted         have           VB      xcomp   
9   in              O               O                 Y                have           in             IN      prep    
10  my              O               O                 Y                room           my             PRP$    poss    
11  room            O               O                 Y                in             room           NN      pobj    
12  ,               O               O                 Y                make           ,              ,       punct   
13  can             O               O                 Y                make           can            MD      aux     
14  I               O               O                 Y                make           I              PRP     nsubj   
15  make            O               O                 Y                make           make           VB      ROOT    
16  sure            O               O                 Y                make           sure           JJ      ccomp   
17  that            O               O                 Y                is             that           DT      nsubj   
18  is              O               O                 Y                sure           be             VBZ     ccomp   
19  ok              O               O                 Y                is             ok             JJ      acomp   

annotated spans:

predicted spans:
  (3, 4): adults

=============================================================================================

Input: heck no!

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   heck            O               O                 Y                heck           heck           UH      ROOT    
1   no              O               O                 Y                heck           no             UH      intj    
2   !               O               O                 Y                heck           !              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: Do you guys have a WiFi password?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Do              O               O                 Y                have           do             VBP     aux     
1   you             O               O                 Y                guys           you            PRP     nmod    
2   guys            O               O                 Y                have           guy            NNS     nsubj   
3   have            O               O                 Y                have           have           VB      ROOT    
4   a               O               O                 Y                password       a              DT      det     
5   WiFi            O               O                 Y       PERSON   password       WiFi           NNP     compound
6   password        O               O                 Y                have           password       NN      dobj    
7   ?               O               O                 Y                have           ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: Can someone fix air conditioning in my room, please?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Can             O               O                 Y                fix            can            MD      aux     
1   someone         O               O                 Y                fix            someone        NN      nsubj   
2   fix             O               O                 Y                please         fix            VB      ccomp   
3   air             O               O                 Y                conditioning   air            NN      compound
4   conditioning    O               O                 Y                fix            conditioning   NN      dobj    
5   in              O               O                 Y                fix            in             IN      prep    
6   my              O               O                 Y                room           my             PRP$    poss    
7   room            O               O                 Y                in             room           NN      pobj    
8   ,               O               O                 Y                please         ,              ,       punct   
9   please          O               O                 Y                please         please         UH      ROOT    
10  ?               O               O                 Y                please         ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: having a jacuzzi is definitely more than what I expected

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   having          O               O                 Y                is             have           VBG     csubj   
1   a               O               O                 Y                jacuzzi        a              DT      det     
2   jacuzzi         O               O                 Y                having         jacuzzi        NN      dobj    
3   is              O               O                 Y                is             be             VBZ     ROOT    
4   definitely      O               O                 Y                is             definitely     RB      advmod  
5   more            O               O                 Y                is             more           JJR     acomp   
6   than            O               O                 Y                more           than           IN      prep    
7   what            O               O                 Y                expected       what           WP      dobj    
8   I               O               O                 Y                expected       I              PRP     nsubj   
9   expected        O               O                 Y                than           expect         VBD     pcomp   

annotated spans:

predicted spans:

=============================================================================================

Input: I heard there you have a jogging trail

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                heard          I              PRP     nsubj   
1   heard           O               O                 Y                heard          hear           VBD     ROOT    
2   there           O               O                 Y                heard          there          RB      advmod  
3   you             O               O                 Y                have           you            PRP     nsubj   
4   have            O               O                 Y                heard          have           VBP     ccomp   
5   a               O               O                 Y                trail          a              DT      det     
6   jogging         O               O                 Y                trail          jog            VBG     amod    
7   trail           O               O                 Y                have           trail          NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: How much is extra parking?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   How             O               O                 Y                much           how            WRB     advmod  
1   much            O               O                 Y                is             much           JJ      acomp   
2   is              O               O                 Y                is             be             VBZ     ROOT    
3   extra           O               O                 Y                parking        extra          JJ      amod    
4   parking         O               O                 Y                is             parking        NN      nsubj   
5   ?               O               O                 Y                is             ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: We'll be coming with 1 cars and will probably need the same number of parking spots.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   We              O               O                 Y                coming         we             PRP     nsubj   
1   'll             O               O                 Y                coming         'll            MD      aux     
2   be              O               O                 Y                coming         be             VB      aux     
3   coming          O               O                 Y                coming         come           VBG     ROOT    
4   with            O               O                 Y                coming         with           IN      prep    
5   1               B-number        B-kids               N    CARDINAL cars           1              CD      nummod  
6   cars            O               O                 Y                with           car            NNS     pobj    
7   and             O               O                 Y                coming         and            CC      cc      
8   will            O               O                 Y                need           will           MD      aux     
9   probably        O               O                 Y                need           probably       RB      advmod  
10  need            O               O                 Y                coming         need           VB      conj    
11  the             O               O                 Y                number         the            DT      det     
12  same            O               O                 Y                number         same           JJ      amod    
13  number          O               O                 Y                need           number         NN      dobj    
14  of              O               O                 Y                number         of             IN      prep    
15  parking         O               O                 Y                spots          parking        NN      compound
16  spots           O               O                 Y                of             spot           NNS     pobj    
17  .               O               O                 Y                coming         .              .       punct   

annotated spans:
  (5, 6): number         

predicted spans:
  (5, 6): kids

=============================================================================================

Input: my camera seems to be missing

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   my              O               O                 Y                camera         my             PRP$    poss    
1   camera          O               O                 Y                seems          camera         NN      nsubj   
2   seems           O               O                 Y                seems          seem           VBZ     ROOT    
3   to              O               O                 Y                missing        to             TO      aux     
4   be              O               O                 Y                missing        be             VB      aux     
5   missing         O               O                 Y                seems          miss           VBG     xcomp   

annotated spans:

predicted spans:

=============================================================================================

Input: Where can I leave my car?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Where           O               O                 Y                leave          where          WRB     advmod  
1   can             O               O                 Y                leave          can            MD      aux     
2   I               O               O                 Y                leave          I              PRP     nsubj   
3   leave           O               O                 Y                leave          leave          VB      ROOT    
4   my              O               O                 Y                car            my             PRP$    poss    
5   car             O               O                 Y                leave          car            NN      dobj    
6   ?               O               O                 Y                leave          ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: any room free this evening already?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   any             O               O                 Y                room           any            DT      det     
1   room            O               O                 Y                free           room           NN      nsubj   
2   free            O               O                 Y                free           free           JJ      ROOT    
3   this            B-time_period   O                    N             evening        this           DT      det     
4   evening         I-time_period   O                    N             free           evening        NN      npadvmod
5   already         O               O                 Y                free           already        RB      advmod  
6   ?               O               O                 Y                free           ?              .       punct   

annotated spans:
  (3, 5): time_period    

predicted spans:

=============================================================================================

Input: cancel the 8 40 in the morning restaurant booking under bruggeman

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   cancel          O               O                 Y                cancel         cancel         VB      ROOT    
1   the             O               O                 Y                40             the            DT      det     
2   8               B-time          B-time            Y                40             8              CD      compound
3   40              I-time          I-time            Y                cancel         40             CD      dobj    
4   in              I-time          I-time            Y                cancel         in             IN      prep    
5   the             I-time          O                    N             booking        the            DT      det     
6   morning         I-time          B-time_period        N    TIME     booking        morning        NN      compound
7   restaurant      O               O                 Y                booking        restaurant     NN      compound
8   booking         O               O                 Y                in             booking        NN      pobj    
9   under           O               O                 Y                cancel         under          IN      prep    
10  bruggeman       B-person_name   B-date_to            N             under          bruggeman      NN      pobj    

annotated spans:
  (2, 7): time           
  (10, 11): person_name    

predicted spans:
  (2, 5): time
  (6, 7): time_period
  (10, 11): date_to

=============================================================================================

Input: I want to book a room on behalf of shaida sharon, from Jan the 12th.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                book           to             TO      aux     
3   book            O               O                 Y                want           book           VB      xcomp   
4   a               O               B-rooms              N             room           a              DT      det     
5   room            O               O                 Y                book           room           NN      dobj    
6   on              O               O                 Y                room           on             IN      prep    
7   behalf          O               O                 Y                on             behalf         NN      pobj    
8   of              O               O                 Y                behalf         of             IN      prep    
9   shaida          B-person_name   B-person_name     Y                sharon         shaida         NNP     compound
10  sharon          I-person_name   I-person_name     Y       PERSON   of             sharon         NNP     pobj    
11  ,               O               O                 Y                book           ,              ,       punct   
12  from            O               O                 Y                book           from           IN      prep    
13  Jan             B-date_from     B-date_from       Y       DATE     from           Jan            NNP     pobj    
14  the             I-date_from     I-date_from       Y       DATE     12th           the            DT      det     
15  12th            I-date_from     B-date_from          N    DATE     Jan            12th           NN      appos   
16  .               O               O                 Y                want           .              .       punct   

annotated spans:
Y (9, 11): person_name    
  (13, 16): date_from      

predicted spans:
  (4, 5): rooms
Y (9, 11): person_name
  (13, 15): date_from
  (15, 16): date_from

=============================================================================================

Input: I want to get a foot bath on Sunday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                get            to             TO      aux     
3   get             O               O                 Y                want           get            VB      xcomp   
4   a               O               O                 Y                bath           a              DT      det     
5   foot            O               O                 Y                bath           foot           NN      compound
6   bath            O               O                 Y                get            bath           NN      dobj    
7   on              O               O                 Y                bath           on             IN      prep    
8   Sunday          B-date          B-date_from          N    DATE     on             Sunday         NNP     pobj    

annotated spans:
  (8, 9): date           

predicted spans:
  (8, 9): date_from

=============================================================================================

Input: Is there a cash machine on the premises?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Is              O               O                 Y                Is             be             VBZ     ROOT    
1   there           O               O                 Y                Is             there          EX      expl    
2   a               O               B-rooms              N             machine        a              DT      det     
3   cash            O               O                 Y                machine        cash           NN      compound
4   machine         O               O                 Y                Is             machine        NN      attr    
5   on              O               O                 Y                machine        on             IN      prep    
6   the             O               O                 Y                premises       the            DT      det     
7   premises        O               O                 Y                on             premise        NNS     pobj    
8   ?               O               O                 Y                Is             ?              .       punct   

annotated spans:

predicted spans:
  (2, 3): rooms

=============================================================================================

Input: speak to room service

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   speak           O               O                 Y                speak          speak          VB      ROOT    
1   to              O               O                 Y                room           to             TO      aux     
2   room            O               O                 Y                service        room           NN      compound
3   service         O               O                 Y                speak          service        NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a reservation and I need to change the number of adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                have           I              PRP     nsubj   
1   have            O               O                 Y                have           have           VBP     ROOT    
2   a               O               O                 Y                reservation    a              DT      det     
3   reservation     O               O                 Y                have           reservation    NN      dobj    
4   and             O               O                 Y                have           and            CC      cc      
5   I               O               O                 Y                need           I              PRP     nsubj   
6   need            O               O                 Y                have           need           VBP     conj    
7   to              O               O                 Y                change         to             TO      aux     
8   change          O               O                 Y                need           change         VB      xcomp   
9   the             O               O                 Y                number         the            DT      det     
10  number          O               O                 Y                change         number         NN      dobj    
11  of              O               O                 Y                number         of             IN      prep    
12  adults          O               O                 Y                of             adult          NNS     pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a booking and I need to amend the number of adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                have           I              PRP     nsubj   
1   have            O               O                 Y                have           have           VBP     ROOT    
2   a               O               O                 Y                booking        a              DT      det     
3   booking         O               O                 Y                have           booking        NN      dobj    
4   and             O               O                 Y                have           and            CC      cc      
5   I               O               O                 Y                need           I              PRP     nsubj   
6   need            O               O                 Y                have           need           VBP     conj    
7   to              O               O                 Y                amend          to             TO      aux     
8   amend           O               O                 Y                need           amend          VB      xcomp   
9   the             O               O                 Y                number         the            DT      det     
10  number          O               O                 Y                amend          number         NN      dobj    
11  of              O               O                 Y                number         of             IN      prep    
12  adults          O               O                 Y                of             adult          NNS     pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a booking and I need to change the number of adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                have           I              PRP     nsubj   
1   have            O               O                 Y                have           have           VBP     ROOT    
2   a               O               O                 Y                booking        a              DT      det     
3   booking         O               O                 Y                have           booking        NN      dobj    
4   and             O               O                 Y                have           and            CC      cc      
5   I               O               O                 Y                need           I              PRP     nsubj   
6   need            O               O                 Y                have           need           VBP     conj    
7   to              O               O                 Y                change         to             TO      aux     
8   change          O               O                 Y                need           change         VB      xcomp   
9   the             O               O                 Y                number         the            DT      det     
10  number          O               O                 Y                change         number         NN      dobj    
11  of              O               O                 Y                number         of             IN      prep    
12  adults          O               O                 Y                of             adult          NNS     pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a reservation and I need to amend the number of adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                have           I              PRP     nsubj   
1   have            O               O                 Y                have           have           VBP     ROOT    
2   a               O               O                 Y                reservation    a              DT      det     
3   reservation     O               O                 Y                have           reservation    NN      dobj    
4   and             O               O                 Y                have           and            CC      cc      
5   I               O               O                 Y                need           I              PRP     nsubj   
6   need            O               O                 Y                have           need           VBP     conj    
7   to              O               O                 Y                amend          to             TO      aux     
8   amend           O               O                 Y                need           amend          VB      xcomp   
9   the             O               O                 Y                number         the            DT      det     
10  number          O               O                 Y                amend          number         NN      dobj    
11  of              O               O                 Y                number         of             IN      prep    
12  adults          O               O                 Y                of             adult          NNS     pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: please change the time of my table booking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   please          O               O                 Y                change         please         UH      intj    
1   change          O               O                 Y                change         change         VB      ROOT    
2   the             O               O                 Y                time           the            DT      det     
3   time            O               O                 Y                change         time           NN      dobj    
4   of              O               O                 Y                time           of             IN      prep    
5   my              O               O                 Y                booking        my             PRP$    poss    
6   table           O               O                 Y                booking        table          NN      compound
7   booking         O               O                 Y                of             booking        NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I want to modify the adults

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                modify         to             TO      aux     
3   modify          O               O                 Y                want           modify         VB      xcomp   
4   the             O               O                 Y                adults         the            DT      det     
5   adults          O               O                 Y                modify         adult          NNS     dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: Looking for a room from the 1st to the 17th for 8 people

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Looking         O               O                 Y                Looking        look           VBG     ROOT    
1   for             O               O                 Y                Looking        for            IN      prep    
2   a               O               O                 Y                room           a              DT      det     
3   room            O               I-rooms              N             for            room           NN      pobj    
4   from            O               O                 Y                room           from           IN      prep    
5   the             O               O                 Y       DATE     1st            the            DT      det     
6   1st             B-date_from     B-date_from       Y       DATE     from           1st            NN      pobj    
7   to              O               O                 Y       DATE     Looking        to             IN      prep    
8   the             O               O                 Y       DATE     17th           the            DT      det     
9   17th            B-date_to       B-date_from          N    DATE     to             17th           NN      pobj    
10  for             O               O                 Y                Looking        for            IN      prep    
11  8               B-people        B-people          Y       CARDINAL people         8              CD      nummod  
12  people          O               O                 Y                for            people         NNS     pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (6, 7): date_from      
  (9, 10): date_to        
Y (11, 12): people         

predicted spans (incorrectly extracted from BIO tags):
Y (6, 7): date_from
  (9, 10): date_from
Y (11, 12): people

=============================================================================================

Input: Tuesday March 3

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Tuesday         B-date          B-date            Y       DATE     March          Tuesday        NNP     compound
1   March           I-date          I-date            Y       DATE     March          March          NNP     ROOT    
2   3               I-date          I-date_from          N    DATE     March          3              CD      nummod  

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (0, 3): date           

predicted spans (incorrectly extracted from BIO tags):
Y (0, 3): date

=============================================================================================

Input: Sunday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Sunday          B-date          B-date            Y       DATE     Sunday         Sunday         NNP     ROOT    

annotated spans:
Y (0, 1): date           

predicted spans:
Y (0, 1): date

=============================================================================================

Input: I'd like an en suite room for 2 adults please

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   'd              O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   an              B-rooms         O                    N             room           an             DT      det     
4   en              I-rooms         O                    N             room           en             FW      compound
5   suite           I-rooms         I-rooms           Y                room           suite          NN      compound
6   room            I-rooms         I-rooms           Y                like           room           NN      dobj    
7   for             O               O                 Y                room           for            IN      prep    
8   2               B-adults        B-adults          Y       CARDINAL adults         2              CD      nummod  
9   adults          I-adults        O                    N             for            adult          NNS     pobj    
10  please          O               O                 Y                like           please         UH      intj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (3, 7): rooms          
  (8, 10): adults         

predicted spans (incorrectly extracted from BIO tags):
  (8, 9): adults

=============================================================================================

Input: a double room for tomorrow for 8 days

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   a               B-rooms         B-rooms           Y                room           a              DT      det     
1   double          I-rooms         I-rooms           Y                room           double         JJ      amod    
2   room            I-rooms         I-rooms           Y                room           room           NN      ROOT    
3   for             O               O                 Y                room           for            IN      prep    
4   tomorrow        B-date_from     O                    N    DATE     for            tomorrow       NN      pobj    
5   for             O               O                 Y                room           for            IN      prep    
6   8               B-date_period   B-date_period     Y       DATE     days           8              CD      nummod  
7   days            I-date_period   I-date_period     Y       DATE     for            day            NNS     pobj    

annotated spans:
Y (0, 3): rooms          
  (4, 5): date_from      
Y (6, 8): date_period    

predicted spans:
Y (0, 3): rooms
Y (6, 8): date_period

=============================================================================================

Input: From the 16th to the 30th, a single room for 2 adults and 1 child.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   From            O               O                 Y                room           from           IN      prep    
1   the             O               O                 Y       DATE     16th           the            DT      det     
2   16th            B-date_from     B-date_from       Y       DATE     From           16th           NN      pobj    
3   to              O               O                 Y       DATE     From           to             IN      prep    
4   the             O               O                 Y       DATE     30th           the            DT      det     
5   30th            B-date_to       I-date_from          N    DATE     to             30th           NN      pobj    
6   ,               O               O                 Y                room           ,              ,       punct   
7   a               B-rooms         O                    N             room           a              DT      det     
8   single          I-rooms         I-rooms           Y                room           single         JJ      amod    
9   room            I-rooms         I-rooms           Y                room           room           NN      ROOT    
10  for             O               O                 Y                room           for            IN      prep    
11  2               B-adults        B-adults          Y       CARDINAL adults         2              CD      nummod  
12  adults          O               O                 Y                for            adult          NNS     pobj    
13  and             O               O                 Y                adults         and            CC      cc      
14  1               B-kids          B-kids            Y       CARDINAL child          1              CD      nummod  
15  child           O               O                 Y                adults         child          NN      conj    
16  .               O               O                 Y                room           .              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (2, 3): date_from      
  (5, 6): date_to        
  (7, 10): rooms          
Y (11, 12): adults         
Y (14, 15): kids           

predicted spans (incorrectly extracted from BIO tags):
Y (2, 3): date_from
Y (11, 12): adults
Y (14, 15): kids

=============================================================================================

Input: I want to book for today

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                book           to             TO      aux     
3   book            O               O                 Y                want           book           VB      xcomp   
4   for             O               O                 Y                book           for            IN      prep    
5   today           B-date_from     O                    N    DATE     for            today          NN      pobj    

annotated spans:
  (5, 6): date_from      

predicted spans:

=============================================================================================

Input: for a week

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   for             O               O                 Y                for            for            IN      ROOT    
1   a               B-date_period   B-date_period     Y       DATE     week           a              DT      det     
2   week            I-date_period   I-date_period     Y       DATE     for            week           NN      pobj    

annotated spans:
Y (1, 3): date_period    

predicted spans:
Y (1, 3): date_period

=============================================================================================

Input: 5 nights from 15th of October?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   5               B-date_period   B-date_period     Y       DATE     nights         5              CD      nummod  
1   nights          I-date_period   I-date_period     Y       DATE     nights         night          NNS     ROOT    
2   from            O               O                 Y       DATE     nights         from           IN      prep    
3   15th            B-date_from     B-date_from       Y       DATE     from           15th           NN      pobj    
4   of              I-date_from     I-date_to            N             15th           of             IN      prep    
5   October         I-date_from     B-date_from          N    DATE     of             October        NNP     pobj    
6   ?               O               O                 Y                nights         ?              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (0, 2): date_period    
  (3, 6): date_from      

predicted spans (incorrectly extracted from BIO tags):
Y (0, 2): date_period
  (3, 5): date_from
  (5, 6): date_from

=============================================================================================

Input: 2 weeks

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   2               B-date_period   I-date               N    DATE     weeks          2              CD      nummod  
1   weeks           I-date_period   O                    N    DATE     weeks          week           NNS     ROOT    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (0, 2): date_period    

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: 1 adults and 8 children. Saturday to Tuesday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   1               B-adults        B-adults          Y       CARDINAL adults         1              CD      nummod  
1   adults          O               O                 Y                adults         adult          NNS     ROOT    
2   and             O               O                 Y                adults         and            CC      cc      
3   8               B-kids          B-kids            Y       CARDINAL children       8              CD      nummod  
4   children        O               O                 Y                adults         child          NNS     conj    
5   .               O               O                 Y                adults         .              .       punct   
6   Saturday        B-date_from     B-date_from       Y       DATE     Saturday       Saturday       NNP     ROOT    
7   to              O               O                 Y       DATE     Saturday       to             IN      prep    
8   Tuesday         B-date_to       B-date_to         Y       DATE     to             Tuesday        NNP     pobj    

annotated spans:
Y (0, 1): adults         
Y (3, 4): kids           
Y (6, 7): date_from      
Y (8, 9): date_to        

predicted spans:
Y (0, 1): adults
Y (3, 4): kids
Y (6, 7): date_from
Y (8, 9): date_to

=============================================================================================

Input: our two kids and I

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   our             O               O                 Y                kids           our            PRP$    poss    
1   two             B-kids          B-kids            Y       CARDINAL kids           two            CD      nummod  
2   kids            O               O                 Y                kids           kid            NNS     ROOT    
3   and             O               O                 Y                kids           and            CC      cc      
4   I               B-adults        O                    N             kids           I              PRP     conj    

annotated spans:
Y (1, 2): kids           
  (4, 5): adults         

predicted spans:
Y (1, 2): kids

=============================================================================================

Input: I'd like to arrive on Wednesday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   'd              O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   to              O               O                 Y                arrive         to             TO      aux     
4   arrive          O               O                 Y                like           arrive         VB      xcomp   
5   on              O               O                 Y                arrive         on             IN      prep    
6   Wednesday       B-date_from     B-date_from       Y       DATE     on             Wednesday      NNP     pobj    

annotated spans:
Y (6, 7): date_from      

predicted spans:
Y (6, 7): date_from

=============================================================================================

Input: leaving on the 12th, arriving on the 10th

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   leaving         O               O                 Y                leaving        leave          VBG     ROOT    
1   on              O               O                 Y                leaving        on             IN      prep    
2   the             O               O                 Y       DATE     12th           the            DT      det     
3   12th            B-date_to       I-date_from          N    DATE     on             12th           NN      pobj    
4   ,               O               O                 Y                leaving        ,              ,       punct   
5   arriving        O               O                 Y                leaving        arrive         VBG     advcl   
6   on              O               O                 Y                arriving       on             IN      prep    
7   the             O               O                 Y                10th           the            DT      det     
8   10th            B-date_from     B-date_from       Y       ORDINAL  on             10th           JJ      pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (3, 4): date_to        
Y (8, 9): date_from      

predicted spans (incorrectly extracted from BIO tags):
Y (8, 9): date_from

=============================================================================================

Input: I'm leaving on Thursday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                leaving        I              PRP     nsubj   
1   'm              O               O                 Y                leaving        be             VBP     aux     
2   leaving         O               O                 Y                leaving        leave          VBG     ROOT    
3   on              O               O                 Y                leaving        on             IN      prep    
4   Thursday        B-date_to       B-date_from          N    DATE     leaving        Thursday       NNP     npadvmod

annotated spans:
  (4, 5): date_to        

predicted spans:
  (4, 5): date_from

=============================================================================================

Input: Something's wrong with the shower, only cold water since 25 past 17 afternoon today.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Something       O               O                 Y                wrong          something      NN      poss    
1   's              O               O                 Y                Something      's             POS     case    
2   wrong           O               O                 Y                wrong          wrong          NN      ROOT    
3   with            O               O                 Y                wrong          with           IN      prep    
4   the             O               O                 Y                shower         the            DT      det     
5   shower          O               O                 Y                with           shower         NN      pobj    
6   ,               O               O                 Y                shower         ,              ,       punct   
7   only            O               O                 Y                water          only           RB      advmod  
8   cold            O               O                 Y                water          cold           JJ      amod    
9   water           O               O                 Y                shower         water          NN      appos   
10  since           O               O                 Y                wrong          since          IN      prep    
11  25              B-time_from     B-time               N    TIME     afternoon      25             CD      nummod  
12  past            I-time_from     I-time               N    TIME     afternoon      past           JJ      amod    
13  17              I-time_from     I-time               N    TIME     afternoon      17             CD      nummod  
14  afternoon       I-time_from     I-date_from          N    TIME     since          afternoon      NN      pobj    
15  today           B-date          B-date            Y       DATE     wrong          today          NN      npadvmod
16  .               O               O                 Y                wrong          .              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (11, 15): time_from      
Y (15, 16): date           

predicted spans (incorrectly extracted from BIO tags):
  (11, 15): time
Y (15, 16): date

=============================================================================================

Input: I just wanted to confirm the booking and that's all, thanks and bye-bye!

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                wanted         I              PRP     nsubj   
1   just            O               O                 Y                wanted         just           RB      advmod  
2   wanted          O               O                 Y                wanted         want           VBD     ROOT    
3   to              O               O                 Y                confirm        to             TO      aux     
4   confirm         O               O                 Y                wanted         confirm        VB      xcomp   
5   the             O               O                 Y                booking        the            DT      det     
6   booking         O               O                 Y                confirm        booking        NN      dobj    
7   and             O               O                 Y                wanted         and            CC      cc      
8   that            O               O                 Y                's             that           DT      nsubj   
9   's              O               O                 Y                wanted         be             VBZ     conj    
10  all             O               O                 Y                's             all            DT      attr    
11  ,               O               O                 Y                's             ,              ,       punct   
12  thanks          O               O                 Y                's             thank          NNS     npadvmod
13  and             O               O                 Y                thanks         and            CC      cc      
14  bye             O               O                 Y                thanks         bye            UH      conj    
15  -               O               O                 Y                bye            -              UH      intj    
16  bye             O               O                 Y                thanks         bye            NN      conj    
17  !               O               O                 Y                's             !              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: the room was supposedly cleaned but this is still pretty dirty

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   the             O               O                 Y                room           the            DT      det     
1   room            O               O                 Y                cleaned        room           NN      nsubjpass
2   was             O               O                 Y                cleaned        be             VBD     auxpass 
3   supposedly      O               O                 Y                cleaned        supposedly     RB      advmod  
4   cleaned         O               O                 Y                cleaned        clean          VBN     ROOT    
5   but             O               O                 Y                cleaned        but            CC      cc      
6   this            O               O                 Y                is             this           DT      nsubj   
7   is              O               O                 Y                cleaned        be             VBZ     conj    
8   still           O               O                 Y                is             still          RB      advmod  
9   pretty          O               O                 Y                dirty          pretty         RB      advmod  
10  dirty           O               O                 Y                is             dirty          JJ      acomp   

annotated spans:

predicted spans:

=============================================================================================

Input: how much time does a spa session last?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   how             O               O                 Y                much           how            WRB     advmod  
1   much            O               O                 Y                time           much           JJ      amod    
2   time            O               O                 Y                last           time           NN      npadvmod
3   does            O               O                 Y                last           do             VBZ     aux     
4   a               O               O                 Y                session        a              DT      det     
5   spa             O               O                 Y                session        spa            NN      compound
6   session         O               O                 Y                last           session        NN      nsubj   
7   last            O               O                 Y                last           last           JJ      ROOT    
8   ?               O               O                 Y                last           ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: can I go to the gym if I am in a wheelchair?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   can             O               O                 Y                go             can            MD      aux     
1   I               O               O                 Y                go             I              PRP     nsubj   
2   go              O               O                 Y                go             go             VB      ROOT    
3   to              O               O                 Y                go             to             IN      prep    
4   the             O               O                 Y                gym            the            DT      det     
5   gym             O               O                 Y                to             gym            NN      pobj    
6   if              O               O                 Y                am             if             IN      mark    
7   I               O               O                 Y                am             I              PRP     nsubj   
8   am              O               O                 Y                go             be             VBP     advcl   
9   in              O               O                 Y                am             in             IN      prep    
10  a               O               O                 Y                wheelchair     a              DT      det     
11  wheelchair      O               O                 Y                in             wheelchair     NN      pobj    
12  ?               O               O                 Y                go             ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: i have doubts about my check in date

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y                have           I              PRP     nsubj   
1   have            O               O                 Y                have           have           VBP     ROOT    
2   doubts          O               O                 Y                have           doubt          NNS     dobj    
3   about           O               O                 Y                doubts         about          IN      prep    
4   my              O               O                 Y                check          my             PRP$    poss    
5   check           O               O                 Y                about          check          NN      pobj    
6   in              O               O                 Y                have           in             IN      prep    
7   date            O               O                 Y                in             date           NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: Please tell me that one more time

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Please          O               O                 Y                tell           please         UH      intj    
1   tell            O               O                 Y                tell           tell           VB      ROOT    
2   me              O               O                 Y                tell           I              PRP     dobj    
3   that            O               O                 Y                time           that           IN      det     
4   one             O               O                 Y       CARDINAL time           one            CD      nummod  
5   more            O               O                 Y                time           more           JJR     amod    
6   time            O               O                 Y                tell           time           NN      npadvmod

annotated spans:

predicted spans:

=============================================================================================

Input: Hello, I am calling due to some issues with online check in.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Hello           O               O                 Y                calling        hello          UH      intj    
1   ,               O               O                 Y                calling        ,              ,       punct   
2   I               O               O                 Y                calling        I              PRP     nsubj   
3   am              O               O                 Y                calling        be             VBP     aux     
4   calling         O               O                 Y                calling        call           VBG     ROOT    
5   due             O               O                 Y                calling        due            JJ      prep    
6   to              O               O                 Y                due            to             IN      prep    
7   some            O               O                 Y                issues         some           DT      det     
8   issues          O               O                 Y                to             issue          NNS     pobj    
9   with            O               O                 Y                issues         with           IN      prep    
10  online          O               O                 Y                check          online         JJ      amod    
11  check           O               O                 Y                with           check          NN      pobj    
12  in              O               O                 Y                calling        in             RP      prep    
13  .               O               O                 Y                calling        .              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I need to speak to someone at the restaurant.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                need           I              PRP     nsubj   
1   need            O               O                 Y                need           need           VBP     ROOT    
2   to              O               O                 Y                speak          to             TO      aux     
3   speak           O               O                 Y                need           speak          VB      xcomp   
4   to              O               O                 Y                speak          to             IN      prep    
5   someone         O               O                 Y                to             someone        NN      pobj    
6   at              O               O                 Y                someone        at             IN      prep    
7   the             O               O                 Y                restaurant     the            DT      det     
8   restaurant      O               O                 Y                at             restaurant     NN      pobj    
9   .               O               O                 Y                need           .              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: I'll arrive earlier than what I thought, can I check in already at 12:45 p.m.?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                arrive         I              PRP     nsubj   
1   'll             O               O                 Y                arrive         'll            MD      aux     
2   arrive          O               O                 Y                check          arrive         VB      ccomp   
3   earlier         O               O                 Y                arrive         early          RBR     advmod  
4   than            O               O                 Y                earlier        than           IN      prep    
5   what            O               O                 Y                thought        what           WP      dobj    
6   I               O               O                 Y                thought        I              PRP     nsubj   
7   thought         O               O                 Y                than           think          VBD     pcomp   
8   ,               O               O                 Y                check          ,              ,       punct   
9   can             O               O                 Y                check          can            MD      aux     
10  I               O               O                 Y                check          I              PRP     nsubj   
11  check           O               O                 Y                check          check          VB      ROOT    
12  in              O               O                 Y                check          in             RP      prt     
13  already         O               O                 Y                check          already        RB      advmod  
14  at              O               O                 Y                check          at             IN      prep    
15  12:45           B-time          B-time            Y       TIME     at             12:45          CD      pobj    
16  p.m.            I-time          I-time            Y       TIME     check          p.m.           NN      npadvmod
17  ?               O               O                 Y                check          ?              .       punct   

annotated spans:
Y (15, 17): time           

predicted spans:
Y (15, 17): time

=============================================================================================

Input: when do i need to leave the room my last day?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   when            O               O                 Y                need           when           WRB     advmod  
1   do              O               O                 Y                need           do             VBP     aux     
2   i               O               O                 Y                need           I              PRP     nsubj   
3   need            O               O                 Y                need           need           VB      ROOT    
4   to              O               O                 Y                leave          to             TO      aux     
5   leave           O               O                 Y                need           leave          VB      xcomp   
6   the             O               O                 Y                room           the            DT      det     
7   room            O               O                 Y                leave          room           NN      dobj    
8   my              O               O                 Y                day            my             PRP$    poss    
9   last            O               I-date_period        N    DATE     day            last           JJ      amod    
10  day             O               B-date               N    DATE     leave          day            NN      npadvmod
11  ?               O               O                 Y                need           ?              .       punct   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:

predicted spans (incorrectly extracted from BIO tags):
  (10, 11): date

=============================================================================================

Input: I will be late for my 10 to 4 afternoon restaurant reservation, it's dalana palomares

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                be             I              PRP     nsubj   
1   will            O               O                 Y                be             will           MD      aux     
2   be              O               O                 Y                's             be             VB      ccomp   
3   late            O               O                 Y                be             late           JJ      acomp   
4   for             O               O                 Y                late           for            IN      prep    
5   my              O               O                 Y                reservation    my             PRP$    poss    
6   10              B-time          B-time            Y       TIME     4              10             CD      quantmod
7   to              I-time          O                    N    TIME     4              to             TO      quantmod
8   4               I-time          B-rooms              N    TIME     afternoon      4              CD      nummod  
9   afternoon       I-time          I-time            Y       TIME     reservation    afternoon      NN      compound
10  restaurant      O               O                 Y                reservation    restaurant     NN      compound
11  reservation     O               O                 Y                for            reservation    NN      pobj    
12  ,               O               O                 Y                's             ,              ,       punct   
13  it              O               O                 Y                's             it             PRP     nsubj   
14  's              O               O                 Y                's             be             VBZ     ROOT    
15  dalana          B-person_name   O                    N    PERSON   palomares      dalana         NNP     compound
16  palomares       I-person_name   O                    N             's             palomare       NNS     attr    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (6, 10): time           
  (15, 17): person_name    

predicted spans (incorrectly extracted from BIO tags):
  (6, 7): time
  (8, 10): rooms

=============================================================================================

Input: yep, book it under jon!

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   yep             O               O                 Y                book           yep            UH      intj    
1   ,               O               O                 Y                book           ,              ,       punct   
2   book            O               O                 Y                book           book           NN      ROOT    
3   it              O               O                 Y                book           it             PRP     dobj    
4   under           O               O                 Y                book           under          IN      prep    
5   jon             O               O                 Y                under          jon            NN      pobj    
6   !               O               O                 Y                book           !              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: i don't have a booking yet

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y                have           I              PRP     nsubj   
1   do              O               O                 Y                have           do             VBP     aux     
2   n't             O               O                 Y                have           n't            RB      neg     
3   have            O               O                 Y                have           have           VB      ROOT    
4   a               O               O                 Y                booking        a              DT      det     
5   booking         O               O                 Y                have           booking        NN      dobj    
6   yet             O               O                 Y                have           yet            RB      advmod  

annotated spans:

predicted spans:

=============================================================================================

Input: i want to swim

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                swim           to             TO      aux     
3   swim            O               O                 Y                want           swim           VB      xcomp   

annotated spans:

predicted spans:

=============================================================================================

Input: I'll be arriving with my 4 dogs. Can they enter the premises?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                arriving       I              PRP     nsubj   
1   'll             O               O                 Y                arriving       'll            MD      aux     
2   be              O               O                 Y                arriving       be             VB      aux     
3   arriving        O               O                 Y                arriving       arrive         VBG     ROOT    
4   with            O               O                 Y                arriving       with           IN      prep    
5   my              O               O                 Y                dogs           my             PRP$    poss    
6   4               B-number        B-adults             N    CARDINAL dogs           4              CD      nummod  
7   dogs            O               O                 Y                with           dog            NNS     pobj    
8   .               O               O                 Y                arriving       .              .       punct   
9   Can             O               O                 Y                enter          can            MD      aux     
10  they            O               O                 Y                enter          they           PRP     nsubj   
11  enter           O               O                 Y                enter          enter          VB      ROOT    
12  the             O               O                 Y                premises       the            DT      det     
13  premises        O               O                 Y                enter          premise        NNS     dobj    
14  ?               O               O                 Y                enter          ?              .       punct   

annotated spans:
  (6, 7): number         

predicted spans:
  (6, 7): adults

=============================================================================================

Input: no no not right now

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   no              O               O                 Y                no             no             UH      ROOT    
1   no              O               O                 Y                no             no             UH      intj    
2   not             O               O                 Y                right          not            RB      neg     
3   right           O               O                 Y                now            right          RB      advmod  
4   now             O               O                 Y                no             now            RB      advmod  

annotated spans:

predicted spans:

=============================================================================================

Input: internet is not working

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   internet        O               O                 Y                working        internet       NN      nsubj   
1   is              O               O                 Y                working        be             VBZ     aux     
2   not             O               O                 Y                working        not            RB      neg     
3   working         O               O                 Y                working        work           VBG     ROOT    

annotated spans:

predicted spans:

=============================================================================================

Input: Double room within jacuzzi for a couple. Check in 6th of Sep and check out 22nd of Sep

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Double          B-rooms         B-rooms           Y                room           double         JJ      amod    
1   room            I-rooms         O                    N             room           room           NN      ROOT    
2   within          O               O                 Y                room           within         IN      prep    
3   jacuzzi         O               O                 Y                within         jacuzzi        NNP     pobj    
4   for             O               O                 Y                room           for            IN      prep    
5   a               B-adults        O                    N             couple         a              DT      det     
6   couple          I-adults        I-date_to            N             for            couple         NN      pobj    
7   .               O               O                 Y                room           .              .       punct   
8   Check           O               O                 Y                Check          check          VB      ROOT    
9   in              O               O                 Y                Check          in             IN      prep    
10  6th             B-date_from     B-date_from       Y       ORDINAL  in             6th            NN      pobj    
11  of              I-date_from     O                    N             6th            of             IN      prep    
12  Sep             I-date_from     O                    N    ORG      of             Sep            NNP     pobj    
13  and             O               O                 Y                Check          and            CC      cc      
14  check           O               O                 Y                Check          check          VB      conj    
15  out             O               O                 Y                check          out            RP      prt     
16  22nd            B-date_to       B-date_from          N             check          22nd           NN      dobj    
17  of              I-date_to       I-date_from          N             22nd           of             IN      prep    
18  Sep             I-date_to       O                    N             of             Sep            NNP     pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (0, 2): rooms          
  (5, 7): adults         
  (10, 13): date_from      
  (16, 19): date_to        

predicted spans (incorrectly extracted from BIO tags):
  (0, 1): rooms
  (10, 11): date_from
  (16, 18): date_from

=============================================================================================

Input: is it possible to reserve a treadmill in the gym?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   is              O               O                 Y                is             be             VBZ     ROOT    
1   it              O               O                 Y                is             it             PRP     nsubj   
2   possible        O               O                 Y                is             possible       JJ      acomp   
3   to              O               O                 Y                reserve        to             TO      aux     
4   reserve         O               O                 Y                is             reserve        VB      xcomp   
5   a               O               O                 Y                treadmill      a              DT      det     
6   treadmill       O               O                 Y                reserve        treadmill      NN      dobj    
7   in              O               O                 Y                reserve        in             IN      prep    
8   the             O               O                 Y                gym            the            DT      det     
9   gym             O               O                 Y                in             gym            NN      pobj    
10  ?               O               O                 Y                is             ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: whats the price of skincare treatments?

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   what            O               O                 Y                s              what           WP      attr    
1   s               O               O                 Y                s              s              VBZ     ROOT    
2   the             O               O                 Y                price          the            DT      det     
3   price           O               O                 Y                s              price          NN      nsubj   
4   of              O               O                 Y                price          of             IN      prep    
5   skincare        O               O                 Y                treatments     skincare       NN      compound
6   treatments      O               O                 Y                of             treatment      NNS     pobj    
7   ?               O               O                 Y                s              ?              .       punct   

annotated spans:

predicted spans:

=============================================================================================

Input: it will be 7

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   it              O               O                 Y                be             it             PRP     nsubj   
1   will            O               O                 Y                be             will           MD      aux     
2   be              O               O                 Y                be             be             VB      ROOT    
3   7               B-number        B-people             N    CARDINAL be             7              CD      attr    

annotated spans:
  (3, 4): number         

predicted spans:
  (3, 4): people

=============================================================================================

Input: Lost property

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Lost            O               I-kids               N             property       lose           VBN     amod    
1   property        O               O                 Y                property       property       NN      ROOT    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: I might pick up a rental car, do you have parking on site

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                pick           I              PRP     nsubj   
1   might           O               O                 Y                pick           might          MD      aux     
2   pick            O               O                 Y                have           pick           VB      ccomp   
3   up              O               O                 Y                pick           up             RP      prt     
4   a               O               O                 Y                car            a              DT      det     
5   rental          O               O                 Y                car            rental         JJ      amod    
6   car             O               O                 Y                pick           car            NN      dobj    
7   ,               O               O                 Y                have           ,              ,       punct   
8   do              O               O                 Y                have           do             VBP     aux     
9   you             O               O                 Y                have           you            PRP     nsubj   
10  have            O               O                 Y                have           have           VB      ROOT    
11  parking         O               O                 Y                have           parking        NN      dobj    
12  on              O               O                 Y                parking        on             IN      prep    
13  site            O               O                 Y                on             site           NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I want to stay tomorrow night

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                stay           to             TO      aux     
3   stay            O               O                 Y                want           stay           VB      xcomp   
4   tomorrow        B-date_from     B-date               N    DATE     night          tomorrow       NN      compound
5   night           B-time_period   B-time_period     Y                stay           night          NN      npadvmod

annotated spans:
  (4, 5): date_from      
Y (5, 6): time_period    

predicted spans:
  (4, 5): date
Y (5, 6): time_period

=============================================================================================

Input: i cant make it to my restaurant booking at 2:10 night

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y                make           I              PRP     nsubj   
1   ca              O               O                 Y                make           ca             MD      aux     
2   nt              O               O                 Y                make           nt             RB      neg     
3   make            O               O                 Y                make           make           VB      ROOT    
4   it              O               O                 Y                make           it             PRP     dobj    
5   to              O               O                 Y                make           to             IN      prep    
6   my              O               O                 Y                booking        my             PRP$    poss    
7   restaurant      O               O                 Y                booking        restaurant     NN      compound
8   booking         O               O                 Y                to             booking        NN      pobj    
9   at              O               O                 Y                make           at             IN      prep    
10  2:10            B-time          B-date_from          N    TIME     night          2:10           CD      nummod  
11  night           I-time          I-time_to            N    TIME     at             night          NN      pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (10, 12): time           

predicted spans (incorrectly extracted from BIO tags):
  (10, 12): date_from

=============================================================================================

Input: please just cancel that booking for murad as I got ill.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   please          O               O                 Y                cancel         please         UH      intj    
1   just            O               O                 Y                cancel         just           RB      advmod  
2   cancel          O               O                 Y                cancel         cancel         VB      ROOT    
3   that            O               O                 Y                booking        that           IN      det     
4   booking         O               O                 Y                cancel         booking        NN      dobj    
5   for             O               O                 Y                booking        for            IN      prep    
6   murad           B-person_name   O                    N             for            murad          NN      pobj    
7   as              O               O                 Y                got            as             IN      mark    
8   I               O               O                 Y                got            I              PRP     nsubj   
9   got             O               O                 Y                cancel         get            VBD     advcl   
10  ill             O               O                 Y                got            ill            JJ      acomp   
11  .               O               O                 Y                cancel         .              .       punct   

annotated spans:
  (6, 7): person_name    

predicted spans:

=============================================================================================

Input: i need to change the time of my makeup service tomorrow

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   i               O               O                 Y                need           I              PRP     nsubj   
1   need            O               O                 Y                need           need           VBP     ROOT    
2   to              O               O                 Y                change         to             TO      aux     
3   change          O               O                 Y                need           change         VB      xcomp   
4   the             O               O                 Y                time           the            DT      det     
5   time            O               O                 Y                change         time           NN      dobj    
6   of              O               O                 Y                time           of             IN      prep    
7   my              O               O                 Y                service        my             PRP$    poss    
8   makeup          O               O                 Y                service        makeup         NN      compound
9   service         O               O                 Y                of             service        NN      pobj    
10  tomorrow        B-date          B-date            Y       DATE     need           tomorrow       NN      npadvmod

annotated spans:
Y (10, 11): date           

predicted spans:
Y (10, 11): date

=============================================================================================

Input: How do I order caesar salad

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   How             O               O                 Y                order          how            WRB     advmod  
1   do              O               O                 Y                order          do             VBP     aux     
2   I               O               O                 Y                order          I              PRP     nsubj   
3   order           O               O                 Y                order          order          VB      ROOT    
4   caesar          O               O                 Y                salad          caesar         NNP     compound
5   salad           O               O                 Y                order          salad          VBD     ccomp   

annotated spans:

predicted spans:

=============================================================================================

Input: we are in our room and hungry

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   we              O               O                 Y                are            we             PRP     nsubj   
1   are             O               O                 Y                are            be             VBP     ROOT    
2   in              O               O                 Y                are            in             IN      prep    
3   our             O               O                 Y                room           our            PRP$    poss    
4   room            O               O                 Y                in             room           NN      pobj    
5   and             O               O                 Y                are            and            CC      cc      
6   hungry          O               O                 Y                are            hungry         JJ      conj    

annotated spans:

predicted spans:

=============================================================================================

Input: I have a booking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                have           I              PRP     nsubj   
1   have            O               O                 Y                have           have           VBP     ROOT    
2   a               O               O                 Y                booking        a              DT      det     
3   booking         O               O                 Y                have           booking        NN      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: 6 15 I have a table booking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   6               B-time          B-time            Y       CARDINAL 15             6              CD      compound
1   15              I-time          O                    N    CARDINAL have           15             CD      npadvmod
2   I               O               O                 Y                have           I              PRP     nsubj   
3   have            O               O                 Y                have           have           VBP     ROOT    
4   a               O               O                 Y                booking        a              DT      det     
5   table           O               O                 Y                booking        table          NN      compound
6   booking         O               O                 Y                have           booking        NN      dobj    

annotated spans:
  (0, 2): time           

predicted spans:
  (0, 1): time

=============================================================================================

Input: I need a dinning reservation for 5 people on March 13th at 9 pm

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                need           I              PRP     nsubj   
1   need            O               O                 Y                need           need           VBP     ROOT    
2   a               O               O                 Y                reservation    a              DT      det     
3   dinning         O               O                 Y                reservation    dinning        NN      amod    
4   reservation     O               O                 Y                need           reservation    NN      dobj    
5   for             O               O                 Y                reservation    for            IN      prep    
6   5               B-people        B-people          Y       CARDINAL people         5              CD      nummod  
7   people          O               O                 Y                for            people         NNS     pobj    
8   on              O               O                 Y                reservation    on             IN      prep    
9   March           B-date          B-date_from          N    DATE     13th           March          NNP     compound
10  13th            I-date          I-date_to            N    DATE     on             13th           NN      pobj    
11  at              O               O                 Y                need           at             IN      prep    
12  9               B-time          B-time            Y       TIME     pm             9              CD      nummod  
13  pm              I-time          O                    N    TIME     at             pm             NN      pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (6, 7): people         
  (9, 11): date           
  (12, 14): time           

predicted spans (incorrectly extracted from BIO tags):
Y (6, 7): people
  (9, 11): date_from
  (12, 13): time

=============================================================================================

Input: I just want to change some details of my hotel booking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   just            O               O                 Y                want           just           RB      advmod  
2   want            O               O                 Y                want           want           VBP     ROOT    
3   to              O               O                 Y                change         to             TO      aux     
4   change          O               O                 Y                want           change         VB      xcomp   
5   some            O               O                 Y                details        some           DT      det     
6   details         O               O                 Y                change         detail         NNS     dobj    
7   of              O               O                 Y                details        of             IN      prep    
8   my              O               O                 Y                booking        my             PRP$    poss    
9   hotel           O               O                 Y                booking        hotel          NN      compound
10  booking         O               O                 Y                of             booking        NN      pobj    

annotated spans:

predicted spans:

=============================================================================================

Input: I want to change one

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                want           I              PRP     nsubj   
1   want            O               O                 Y                want           want           VBP     ROOT    
2   to              O               O                 Y                change         to             TO      aux     
3   change          O               O                 Y                want           change         VB      xcomp   
4   one             O               O                 Y       CARDINAL change         one            CD      dobj    

annotated spans:

predicted spans:

=============================================================================================

Input: We would like one family room for four from Thursday until Thursday

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   We              O               O                 Y                like           we             PRP     nsubj   
1   would           O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   one             B-rooms         B-rooms           Y                room           one            CD      nummod  
4   family          O               O                 Y                room           family         NN      compound
5   room            O               I-rooms              N             like           room           NN      dobj    
6   for             O               O                 Y                room           for            IN      prep    
7   four            B-people        B-time               N    CARDINAL for            four           CD      pobj    
8   from            O               O                 Y                room           from           IN      prep    
9   Thursday        B-date_from     B-date_from       Y       DATE     from           Thursday       NNP     pobj    
10  until           O               O                 Y                like           until          IN      prep    
11  Thursday        B-date_to       B-date_to         Y       DATE     until          Thursday       NNP     pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (3, 4): rooms          
  (7, 8): people         
Y (9, 10): date_from      
Y (11, 12): date_to        

predicted spans (incorrectly extracted from BIO tags):
Y (3, 4): rooms
  (7, 8): time
Y (9, 10): date_from
Y (11, 12): date_to

=============================================================================================

Input: I'd like to make a reservation for 5 people from Sunday 10 July

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   'd              O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   to              O               O                 Y                make           to             TO      aux     
4   make            O               O                 Y                like           make           VB      xcomp   
5   a               O               O                 Y                reservation    a              DT      det     
6   reservation     O               O                 Y                make           reservation    NN      dobj    
7   for             O               O                 Y                reservation    for            IN      prep    
8   5               B-people        B-people          Y       CARDINAL people         5              CD      nummod  
9   people          O               O                 Y                for            people         NNS     pobj    
10  from            O               O                 Y                make           from           IN      prep    
11  Sunday          B-date_from     B-date_from       Y       DATE     from           Sunday         NNP     pobj    
12  10              I-date_from     I-date               N    DATE     Sunday         10             CD      nummod  
13  July            I-date_from     I-date               N    DATE     like           July           NNP     npadvmod

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (8, 9): people         
Y (11, 14): date_from      

predicted spans (incorrectly extracted from BIO tags):
Y (8, 9): people
Y (11, 14): date_from

=============================================================================================

Input: 18th of Nov

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   18th            B-date          O                    N    DATE     18th           18th           NN      ROOT    
1   of              I-date          I-date_from          N    DATE     18th           of             IN      prep    
2   Nov             I-date          I-date_to            N    DATE     of             Nov            NNP     pobj    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (0, 3): date           

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: One bedroom, 2 adults and one minor child.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   One             B-rooms         B-adults             N    CARDINAL bedroom        one            CD      nummod  
1   bedroom         O               O                 Y                bedroom        bedroom        NN      ROOT    
2   ,               O               O                 Y                bedroom        ,              ,       punct   
3   2               B-adults        B-adults          Y       CARDINAL adults         2              CD      nummod  
4   adults          O               O                 Y                bedroom        adult          NNS     appos   
5   and             O               O                 Y                adults         and            CC      cc      
6   one             B-kids          B-kids            Y       CARDINAL child          one            CD      nummod  
7   minor           O               O                 Y                child          minor          JJ      amod    
8   child           O               O                 Y                adults         child          NN      conj    
9   .               O               O                 Y                bedroom        .              .       punct   

annotated spans:
  (0, 1): rooms          
Y (3, 4): adults         
Y (6, 7): kids           

predicted spans:
  (0, 1): adults
Y (3, 4): adults
Y (6, 7): kids

=============================================================================================

Input: I would like to book a hotel for 2 nights for 6 in three rooms for Friday to Sunday so we can go drinking

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   would           O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   to              O               O                 Y                book           to             TO      aux     
4   book            O               O                 Y                like           book           VB      xcomp   
5   a               O               O                 Y                hotel          a              DT      det     
6   hotel           O               O                 Y                book           hotel          NN      dobj    
7   for             O               O                 Y                book           for            IN      prep    
8   2               B-date_period   B-date_period     Y       DATE     nights         2              CD      nummod  
9   nights          I-date_period   I-date_period     Y       DATE     for            night          NNS     pobj    
10  for             O               O                 Y                book           for            IN      prep    
11  6               O               B-people             N    CARDINAL for            6              CD      pobj    
12  in              O               O                 Y                6              in             IN      prep    
13  three           B-rooms         O                    N    CARDINAL rooms          three          CD      nummod  
14  rooms           O               O                 Y                in             room           NNS     pobj    
15  for             O               O                 Y                book           for            IN      prep    
16  Friday          B-date_from     B-date_from       Y       DATE     for            Friday         NNP     pobj    
17  to              O               I-date               N    DATE     book           to             IN      prep    
18  Sunday          B-date_to       B-date_to         Y       DATE     to             Sunday         NNP     pobj    
19  so              O               O                 Y                go             so             IN      mark    
20  we              O               O                 Y                go             we             PRP     nsubj   
21  can             O               O                 Y                go             can            MD      aux     
22  go              O               O                 Y                like           go             VB      advcl   
23  drinking        O               O                 Y                go             drink          VBG     xcomp   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (8, 10): date_period    
  (13, 14): rooms          
  (16, 17): date_from      
Y (18, 19): date_to        

predicted spans (incorrectly extracted from BIO tags):
Y (8, 10): date_period
  (11, 12): people
  (16, 18): date_from
Y (18, 19): date_to

=============================================================================================

Input: I would like to stay for a fortnight in the cheapest room you have

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                like           I              PRP     nsubj   
1   would           O               O                 Y                like           would          MD      aux     
2   like            O               O                 Y                like           like           VB      ROOT    
3   to              O               O                 Y                stay           to             TO      aux     
4   stay            O               O                 Y                like           stay           VB      xcomp   
5   for             O               O                 Y                stay           for            IN      prep    
6   a               B-date_period   O                    N             fortnight      a              DT      det     
7   fortnight       I-date_period   O                    N             for            fortnight      NN      pobj    
8   in              O               O                 Y                stay           in             IN      prep    
9   the             O               O                 Y                room           the            DT      det     
10  cheapest        O               O                 Y                room           cheap          JJS     amod    
11  room            O               I-rooms              N             in             room           NN      pobj    
12  you             O               O                 Y                have           you            PRP     nsubj   
13  have            O               O                 Y                like           have           VBP     ccomp   

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
  (6, 8): date_period    

predicted spans (incorrectly extracted from BIO tags):

=============================================================================================

Input: I would to book a weekend away for myself and my husband for the 29 May please.

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   I               O               O                 Y                would          I              PRP     nsubj   
1   would           O               O                 Y                would          would          MD      ROOT    
2   to              O               O                 Y                book           to             TO      aux     
3   book            O               O                 Y                would          book           VB      xcomp   
4   a               B-date_period   B-rooms              N    DATE     weekend        a              DT      det     
5   weekend         I-date_period   B-time_period        N    DATE     away           weekend        NN      npadvmod
6   away            O               O                 Y                book           away           RB      advmod  
7   for             O               O                 Y                away           for            IN      prep    
8   myself          B-adults        B-adults          Y                for            myself         PRP     pobj    
9   and             I-adults        I-adults          Y                myself         and            CC      cc      
10  my              I-adults        I-adults          Y                husband        my             PRP$    poss    
11  husband         I-adults        I-adults          Y                myself         husband        NN      conj    
12  for             O               O                 Y                book           for            IN      prep    
13  the             O               O                 Y                May            the            DT      det     
14  29              B-date_from     B-kids               N    CARDINAL May            29             CD      nummod  
15  May             I-date_from     O                    N             please         May            NNP     compound
16  please          O               O                 Y                book           please         UH      intj    
17  .               O               O                 Y                would          .              .       punct   

annotated spans:
  (4, 6): date_period    
Y (8, 12): adults         
  (14, 16): date_from      

predicted spans:
  (4, 5): rooms
  (5, 6): time_period
Y (8, 12): adults
  (14, 15): kids

=============================================================================================

Input: One night for next Friday the 17th

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   One             B-date_period   B-date_period     Y       TIME     night          one            CD      nummod  
1   night           I-date_period   I-date_period     Y       TIME     17th           night          NN      npadvmod
2   for             O               O                 Y                night          for            IN      prep    
3   next            O               B-date_to            N    DATE     Friday         next           JJ      amod    
4   Friday          B-date_from     I-date               N    DATE     for            Friday         NNP     pobj    
5   the             I-date_from     I-date_from       Y                17th           the            DT      det     
6   17th            I-date_from     I-date_from       Y                17th           17th           JJ      ROOT    

!!! Predicted BIO tag sequence is malformed. Some predicted spans were not extracted correctly !!!

annotated spans:
Y (0, 2): date_period    
  (4, 7): date_from      

predicted spans (incorrectly extracted from BIO tags):
Y (0, 2): date_period
  (3, 7): date_to

=============================================================================================

Input: Two nights from Friday 29th

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   Two             B-date_period   B-date_period     Y       DATE     nights         two            CD      nummod  
1   nights          I-date_period   I-date_period     Y       DATE     nights         night          NNS     ROOT    
2   from            O               O                 Y                nights         from           IN      prep    
3   Friday          B-date_from     B-date_from       Y       DATE     29th           Friday         NNP     compound
4   29th            I-date_from     I-date_from       Y       DATE     from           29th           NN      pobj    

annotated spans:
Y (0, 2): date_period    
Y (3, 5): date_from      

predicted spans:
Y (0, 2): date_period
Y (3, 5): date_from

=============================================================================================

Input: two little humans

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   two             B-kids          B-adults             N    CARDINAL humans         two            CD      nummod  
1   little          O               O                 Y                humans         little         JJ      amod    
2   humans          O               O                 Y                humans         human          NNS     ROOT    

annotated spans:
  (0, 1): kids           

predicted spans:
  (0, 1): adults

=============================================================================================

Input: my husband and I will be coming with our three sons

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   my              B-adults        B-adults          Y                husband        my             PRP$    poss    
1   husband         I-adults        I-adults          Y                coming         husband        NN      nsubj   
2   and             I-adults        I-adults          Y                husband        and            CC      cc      
3   I               I-adults        O                    N             husband        I              PRP     conj    
4   will            O               O                 Y                coming         will           MD      aux     
5   be              O               O                 Y                coming         be             VB      aux     
6   coming          O               O                 Y                coming         come           VBG     ROOT    
7   with            O               O                 Y                coming         with           IN      prep    
8   our             O               O                 Y                sons           our            PRP$    poss    
9   three           B-kids          B-kids            Y       CARDINAL sons           three          CD      nummod  
10  sons            O               O                 Y                with           son            NNS     pobj    

annotated spans:
  (0, 4): adults         
Y (9, 10): kids           

predicted spans:
  (0, 3): adults
Y (9, 10): kids

=============================================================================================

Input: myself only

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   myself          B-adults        O                    N             myself         myself         PRP     ROOT    
1   only            O               O                 Y                myself         only           RB      advmod  

annotated spans:
  (0, 1): adults         

predicted spans:

=============================================================================================

Input: 7th to 21st of the month

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   7th             B-date_from     O                    N    DATE     7th            7th            JJ      ROOT    
1   to              O               O                 Y       DATE     7th            to             IN      prep    
2   21st            B-date_to       B-date_to         Y       DATE     to             21st           NN      pobj    
3   of              I-date_to       O                    N    DATE     21st           of             IN      prep    
4   the             I-date_to       O                    N    DATE     month          the            DT      det     
5   month           I-date_to       O                    N    DATE     of             month          NN      pobj    

annotated spans:
  (0, 1): date_from      
  (2, 6): date_to        

predicted spans:
  (2, 3): date_to

=============================================================================================

Input: until the 2nd

Analysis:                                                     
Additional annotations:
idx word            BIO annotation  BIO prediction  correct?  ent_type head           lemma_         tag_    dep_    
---------------------------------------------------------------------------------  -------------------------------
0   until           O               O                 Y                until          until          IN      ROOT    
1   the             O               O                 Y                2nd            the            DT      det     
2   2nd             B-date_to       B-date_from          N    ORDINAL  until          2nd            JJ      pobj    

annotated spans:
  (2, 3): date_to        

predicted spans:
  (2, 3): date_from

=============================================================================================


Classification report for BIO tags:

               precision    recall  f1-score   support

     B-adults       0.60      0.67      0.63         9
       B-date       0.62      0.62      0.62         8
  B-date_from       0.57      0.65      0.60        20
B-date_period       1.00      0.67      0.80         9
    B-date_to       0.67      0.36      0.47        11
       B-kids       0.71      0.83      0.77         6
     B-number       0.00      0.00      0.00         3
     B-people       0.60      0.75      0.67         4
B-person_name       0.50      0.25      0.33         4
      B-rooms       0.38      0.33      0.35         9
       B-time       0.71      0.83      0.77         6
  B-time_from       0.00      0.00      0.00         1
B-time_period       0.33      0.33      0.33         3
     I-adults       0.83      0.62      0.71         8
       I-date       0.17      0.20      0.18         5
  I-date_from       0.46      0.40      0.43        15
I-date_period       0.86      0.67      0.75         9
    I-date_to       0.00      0.00      0.00         5
       I-kids       0.00      0.00      0.00         0
     I-number       0.00      0.00      0.00         0
     I-people       0.00      0.00      0.00         0
I-person_name       1.00      0.50      0.67         2
      I-rooms       0.70      0.58      0.64        12
       I-time       0.67      0.36      0.47        11
  I-time_from       0.00      0.00      0.00         3
I-time_period       0.00      0.00      0.00         3

    micro avg       0.58      0.49      0.53       166
    macro avg       0.44      0.37      0.39       166
 weighted avg       0.57      0.49      0.52       166

!!! Classification report for slots is unavailable becausesome predicted BIO tag sequences were malformed !!!
