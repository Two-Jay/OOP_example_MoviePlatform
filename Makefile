JARFILE_NAME = MoviePlatform.jar

SOURCE_PATH = src
TARGET_PATH = target

all :
	@$(MAKE) compile
	@$(MAKE) run

compile : 
	@mvn package

run :
	@java -jar $(TARGET_PATH)/$(JARFILE_NAME)

clean :
	@mvn clean

re : clean all

.PHONY : all compile run clean re