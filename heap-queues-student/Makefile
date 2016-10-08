
DIST = heap-queues-student

dist: javadoc writeup
	mkdir -p $(DIST)
	cp .classpath $(DIST)/
	cp .project $(DIST)/
	cp project.txt $(DIST)/
	cp -r src $(DIST)/
	cp -r test $(DIST)/
	cp -r support $(DIST)/
	mkdir -p $(DIST)/writeup
	cp -r writeup/README.html $(DIST)/writeup/
	cp -r javadoc $(DIST)/writeup/
	zip -r $(DIST) $(DIST)

site: javadoc dist writeup
	mkdir -p site
	cp writeup/README.html site/index.html
	cp -r javadoc site/
	cp $(DIST).zip site/

writeup: writeup/README.html

writeup/README.html: writeup/README.md
	pandoc -o writeup/README.html -H writeup/README.css writeup/README.md

javadoc:
	rm -rf javadoc
	javadoc -sourcepath src:support -d javadoc comparators structures

clean:
	rm -rf javadoc
	rm -rf $(DIST)
	rm -f writeup/README.html

superclean: clean
	rm -f $(DIST).zip
	rm -rf site
