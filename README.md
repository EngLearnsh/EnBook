![EnBook](https://github.com/EngLearnsh/EnBook/blob/master/app/src/main/res/mipmap-xxxhdpi/logo.png)
# EnBook
A dynamic e-book for everyone

English | [中文](https://github.com/EngLearnsh/EnBook/blob/master/README_CN.md)

## Features (Need to be implemented)
1. Material Design UI/UX
2. Local and online bookshelf with massive resources
3. Visual and auditory resources side by side
4. AI recommendations differ by different people
5. Fast syncing personal materials on cloud
6. Powerful download manager which captures fictions in a certain URL
7. Dynamic social platform
....

## Current development status
2020-2-26
1. Create RecyclerView for Main's bookList
2. Searchbox added while clicking Search button
3. Allow user double click to exit
4. Feedback is redirected to GitHub Issues

2020-2-15
1. Create Activities and layouts for Main and Download manager
2. Create DrawerLayout in Main to indicate Actionbar
3. Create Toolbar in Main to indicate Nav / Download / Search / Menu buttons
4. Create Nav header and sample menu buttons inside Nav
5. Create Material AppBarLayout in Download
6. Create floating action button in Download
7. Toast indications are included in alpha stage
8. Case determination when using Toolbar

## Known issues
1. ~~Search is not working in Main~~
2. ~~Loop progress dialog when tapping Feedback~~
3. No animation when tapping Nav button
4. Settings insider Nav is not working
5. Mismatch animation returning from Download to Main
6. Floating button is not working inside Download
7. ~~Built Apks install as a failure~~
8. ~~Mismatch layout of RecyclerView which prevents interactions on Toolbar~~
9. ~~Images might cover books' title in a small screen device~~
10. Images perform a larger size in a small screen device
11. No local search result and hints
12. Bad animation and layout of searchbox
13. ~~Handler may cause memory leak~~
14. ~~Double click to exit is not working after reopening the app~~
15. ~~Internet failure when using feedback~~
16. ~~FC or ANR while using feedback~~
17. No user-friendly-interface on Internet connection judgement
18. No Appbar with back button in Feedback activity