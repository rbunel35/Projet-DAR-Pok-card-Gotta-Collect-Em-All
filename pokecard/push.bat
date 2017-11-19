set /p nom= Nom du commit : 
git add -A
git commit -m "%nom%"
git pull heroku master
git push heroku master