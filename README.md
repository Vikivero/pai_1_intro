## Circuit breakers
 Circuit breakers w aplikacji Netflix są ważnym elementem, który chroni aplikację przed skutkami awarii lub przeciążeń w usługach zewnętrznych. Zapewniają one kontrolowane i efektywne reagowanie na problemy, minimalizując negatywny wpływ na użytkowników i zapewniając płynne działanie aplikacji.
 
## Cascading failures
 Unikanie kaskadowych niepowodzeń jest ważne dla programistów w Netflixie, Allegro i innych firmach budujących serwisy internetowe, ponieważ pozwala na utrzymanie wysokiej dostępności usług, zapewnienie odpowiedniej wydajności systemu, ułatwienie debugowania problemów i zwiększenie odporności na awarie. Unikanie kaskadowych niepowodzeń jest kluczowym aspektem projektowania i utrzymania stabilnych i niezawodnych aplikacji.
 
## Graceful degradation
 Dla programistów w Amazonie i innych firmach budujących serwisy internetowe, graceful degradation jest ważnym elementem, który pozwala na utrzymanie dostępności usług, zapewnienie pozytywnego doświadczenia użytkownika, ograniczenie wpływu błędów, skalowalność systemu oraz ułatwienie debugowania.
 
## Instalacja curl i jq
Upewnij się, że masz zainstalowane narzędzia ##curl i ##jq na swoim systemie operacyjnym. Dla instalacij jq uzyj polecenie w bash: 
sudo apt install jq
Dla instalacij curl uzyj polecenie w bash: 
sudo apt install curl
Albo inne polecenia ktore znasz. 

## Wyswietlenie imiona superbohaterow
Urzyj ponizej podany pryklad aby wypisać imiona super bohaterów z https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json.:

curl -s https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json | jq '.members[].name' 
