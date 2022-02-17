# Test task for Moneta Bank

### Úkol 1
```
Napište program, který bude vystavovat REST službu, která na vstupu bude přijímat text. Služba text transformuje a vrátí zpět.
Transformaci provede tak, že textu otočí pořadí písmen (tedy přečte ho odzadu) s tím, že:
• na pozici, kde se původně vyskytovala písmena a,e,i,o,u budou nově písmena uppercase, všechna ostatní písmena budou lowercase.
• dvě a více mezer spojí do jedné mezery

Např:

Ahoj, jak se máš?
?šÁm es kaj ,jOha

Je     mi   fajn.
.NjaF iM ej
 
Úloha by měla umět zpracovat češtinu.
```

### Úkol 2
```
Napište program, který bude vystavovat REST službu, která na vstupu bude dostávat číslo. Služba s číslem provede výpočet a vrátí zpět.

Výpočet provede postupně takto:
- všechny číslice menší 3 (včetně) posune o jednu pozici doprava. Např: 43256791 => 45326791  
- všechny číslice 8 a 9 vynásobí 2. Např.: 45326791 => 453267181
- všechny číslice 7 smaže: Např: 453267181 => 45326181
- ve výsledném čísle spočte počet sudých číslic a tímto počtem výsledné číslo vydělí a zaokrouhlí dolů na celá čísla. Např: 45326181 / 4 => 11331545

Pro zadané číslo 43256791 je výsledek 11331545.
```
