package visitor.file_system_handling;

public class Main {
    public static void main(String[] args) {

        // Create files
        File f1 = new File("document.txt", 1.2);
        File f2 = new File("photo.jpg", 2.5);
        File f3 = new File("notes.txt", 0.8);
        File f4 = new File("video.mp4", 15.0);
        File f5 = new File("presentation.ppt", 3.4);
        File f6 = new File("music.mp3", 5.6);
        File f7 = new File("archive.zip", 7.8);
        File f8 = new File("music2.mp3", 0.3);
        File f9 = new File("report.pdf", 2.1);
        File f10 = new File("tracklist.txt", 0.2);
        File f11 = new File("cute_cat_video1.mp4", 13.2);
        File f12 = new File("cute_cat_video_2.mp4", 19.8);

        // Create directories
        Directory root = new Directory("root");
        Directory docs = new Directory("documents");
        Directory media = new Directory("media");
        Directory images = new Directory("images");
        Directory videos = new Directory("videos");
        Directory catVideos = new Directory("cat videos");
        Directory misc = new Directory("misc");

        // Build structure

        // documents/
        docs.add(f1);
        docs.add(f3);
        docs.add(f5);
        docs.add(f9);

        // media/
        media.add(f6);
        media.add(f8);
        media.add(f10);

        // images/
        images.add(f2);

        // videos/
        videos.add(f4);
        videos.add(catVideos);
        catVideos.add(f11);
        catVideos.add(f12);

        // misc/
        misc.add(f7);

        // Nest directories
        media.add(images);
        media.add(videos);

        root.add(docs);
        root.add(media);
        root.add(misc);

        // size calculation
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        docs.accept(sizeVisitor);
        sizeVisitor.printTotalSize();
        media.accept(sizeVisitor);
        sizeVisitor.printTotalSize();
        System.out.println();

        // search .txt files
        SearchVisitor txtSearchVisitor = new SearchVisitor(".txt");
        docs.accept(txtSearchVisitor);
        txtSearchVisitor.printMatchedFiles();
        media.accept(txtSearchVisitor);
        txtSearchVisitor.printMatchedFiles();
        System.out.println();

        // search .mp3 files
        SearchVisitor mp3SearchVisitor = new SearchVisitor(".mp3");
        root.accept(mp3SearchVisitor);
        mp3SearchVisitor.printMatchedFiles();
    }
}
