del jquery184.js
del tmp.txt
(dir %1 /aa /b /s | findstr /e /c:"js") >tmp.txt
for /f %%i in (tmp.txt) do type %%i >>jquery184.js  
del tmp.txt
