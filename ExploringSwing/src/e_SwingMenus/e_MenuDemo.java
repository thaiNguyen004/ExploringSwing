package e_SwingMenus;

/*
* Tạo một Menu Chính
* Truyền thống, menu phổ biến nhất là menu chính. Đây là menu được xác định bởi thanh menu và nó xác định tất cả
* (hoặc gần như tất cả) chức năng của một ứng dụng. May mắn thay, Swing giúp việc tạo và quản lý menu chính trở
* nên dễ dàng. Phần này sẽ chỉ bạn cách xây dựng một menu chính cơ bản. Các phần tiếp theo sẽ chỉ bạn cách thêm
* các tùy chọn vào đó.
*
* Để xây dựng menu chính, cần làm một số bước. Đầu tiên, tạo đối tượng JMenuBar để chứa các menu. Tiếp theo,
* xây dựng mỗi menu sẽ có trong thanh menu. Nói chung, một menu được tạo bằng cách tạo đối tượng JMenu trước,
* sau đó thêm các JMenuItems vào nó. Sau khi tạo các menu, thêm chúng vào thanh menu.
*
* Thanh menu chính phải được thêm vào frame bằng cách gọi setJMenuBar(). Cuối cùng, cho mỗi menu item, phải
* thêm một action listener xử lý sự kiện action được kích hoạt khi menu item được chọn.
*
* Một cách tốt để hiểu quá trình tạo và quản lý menu là làm việc thông qua một ví dụ. Đây là một chương trình
* tạo một thanh menu đơn giản chứa ba menu.
*
* Menu đầu tiên là menu File tiêu chuẩn chứa các lựa chọn Open, Close, Save và Exit.
* Menu thứ hai được gọi là Options và nó chứa hai submenu gọi là Colors và Priority.
* Menu thứ ba được gọi là Help và nó có một mục: About.
*
* Khi một menu item được chọn, tên của lựa chọn sẽ được hiển thị trong một nhãn trên nội dung của cửa sổ.
*
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class e_MenuDemo implements ActionListener {
    JLabel jlab = new JLabel();
    e_MenuDemo() {
        JFrame jfrm = new JFrame("Demo Menu");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(220, 200);
        jfrm.setLayout(new FlowLayout());

        //Khởi tạo một nhãn sẽ hiển thị các tùy menu item được chọn
        jlab = new JLabel();

        //Tạo ra một JMenuBar
        JMenuBar jmb = new JMenuBar();

        //Tạo ra một File menu
        JMenu jmFile = new JMenu("File");
        JMenuItem jmiOpen = new JMenuItem("Open");
        JMenuItem jmiClose = new JMenuItem("Close");
        JMenuItem jmiSave = new JMenuItem("Save");
        JMenuItem jmiExit = new JMenuItem("Exit");
        //thêm các menu item vào JMenu
        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.add(jmiSave);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        //Thêm JMenu vào JMenuBar
        jmb.add(jmFile);

        //Tạo ra một Options menu
        JMenu jmOptions = new JMenu("Options");

        //Tạo ra một submenu của menu Options
        JMenu jmColors = new JMenu("Colors");
        JMenuItem jmiRed = new JMenuItem("Red");
        JMenuItem jmiGreen = new JMenuItem("Green");
        JMenuItem jmiBlue = new JMenuItem("Blue");
        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);

        jmOptions.add(jmColors);

        //Tiếp tục tạo ra một submenu của menu Options
        JMenu jmPriority = new JMenu("Priority");
        JMenuItem jmiLow = new JMenuItem("Low");
        JMenuItem jmiHigh = new JMenuItem("High");
        jmPriority.add(jmiLow);
        jmPriority.add(jmiHigh);

        jmOptions.add(jmPriority);

        //Tạo ra một menu item Reset
        JMenuItem jmiReset = new JMenuItem("Reset");
        //Tạo một đường thẳng phân cách 2 option là Colors và Priority với JMenuItem Reset
        jmOptions.addSeparator();
        jmOptions.add(jmiReset);

        //Cuối cùng thêm JMenu Options vào JMenuBar
        jmb.add(jmOptions);

        //Tạo ra JMenu Help
        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);

        //Thêm lắng nghe sự kiện cho các JMenuItem
        jmiOpen.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiRed.addActionListener(this);
        jmiGreen.addActionListener(this);
        jmiBlue.addActionListener(this);
        jmiLow.addActionListener(this);
        jmiHigh.addActionListener(this);
        jmiReset.addActionListener(this);
        jmiAbout.addActionListener(this);

        //Thêm JLabel vào content pane
        jfrm.add(jlab);

        //Thêm menu bar vào frame
        jfrm.setJMenuBar(jmb);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Exit"))
            System.exit(0);
        jlab.setText(str + " selected");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new e_MenuDemo();
            }
        });
    }
}
/*
* Hãy xem xét chi tiết cách tạo menu trong chương trình này, bắt đầu với constructor MenuDemo. Nó bắt đầu bằng
* cách tạo một JFrame và thiết lập trình quản lý bố cục, kích thước và hoạt động đóng mặc định của nó.
* (Các hoạt động này được mô tả trong Chương 31.) Sau đó, một JLabel được tạo ra. Nó sẽ được sử dụng để
* hiển thị một lựa chọn trong menu. Tiếp theo, thanh menu được tạo và một tham chiếu đến nó được gán cho
* jmb bằng câu lệnh sau đây:
* // Tạo thanh menu.
* JMenuBar jmb = new JMenuBar();
*
* Sau đó, menu File jmFile và các mục menu của nó được tạo bằng chuỗi lệnh sau:
*
* // Tạo menu File.
* JMenu jmFile = new JMenu("File");
* JMenuItem jmiOpen = new JMenuItem("Open");
* JMenuItem jmiClose = new JMenuItem("Close");
* JMenuItem jmiSave = new JMenuItem("Save");
* JMenuItem jmiExit = new JMenuItem("Exit");
*
* Các tên Open, Close, Save và Exit sẽ được hiển thị là các lựa chọn trong menu. Tiếp theo, các mục menu
* được thêm vào menu file bằng chuỗi lệnh sau đây:
*
* jmFile.add(jmiOpen);
* jmFile.add(jmiClose);
* jmFile.add(jmiSave);
* jmFile.addSeparator();
* jmFile.add(jmiExit);
*
* Cuối cùng, menu File được thêm vào thanh menu bằng dòng lệnh sau đây:
* jmb.add(jmFile);
*
* Sau khi chuỗi mã trên hoàn tất, thanh menu sẽ chứa một mục: File. Menu File sẽ chứa bốn lựa chọn theo thứ tự:
* Open, Close, Save và Exit. Tuy nhiên, lưu ý rằng đã thêm một dấu ngăn cách trước Exit. Điều này tạo ra sự phân tách
* hình ảnh giữa Exit và ba lựa chọn trước đó.
* Menu Options được xây dựng bằng cách sử dụng quy trình cơ bản giống như menu File. Tuy nhiên, menu Options bao gồm
* hai menu con là Colors và Priority, và mục Reset. Các menu con được xây dựng riêng rẽ và sau đó được thêm
* vào menu Options. Mục Reset được thêm cuối cùng. Sau đó, menu Options được thêm vào thanh menu. Menu Help
* được xây dựng bằng cách sử dụng quy trình tương tự.
*
* Lưu ý rằng MenuDemo triển khai giao diện ActionListener và các sự kiện hành động được tạo ra bởi lựa chọn menu
* được xử lý bởi phương thức actionPerformed() được định nghĩa bởi MenuDemo. Do đó, chương trình thêm nó làm người
* nghe hành động cho các mục menu. Lưu ý rằng không có người nghe được thêm cho các mục Colors hoặc Priority vì
* chúng không phải là các lựa chọn thực sự. Chúng chỉ kích hoạt các menu con.
*
* Cuối cùng, thanh menu được thêm vào khung bằng dòng lệnh sau đây:
*
* jfrm.setJMenuBar(jmb);
*
* Như đã đề cập, thanh menu không được thêm vào nội dung của cửa sổ. Chúng được thêm trực tiếp vào JFrame.
* Phương thức actionPerformed() xử lý các sự kiện hành động được tạo ra bởi menu. Nó lấy chuỗi lệnh hành động
* liên quan đến lựa chọn bằng cách gọi getActionCommand() trên sự kiện. Nó lưu trữ một tham chiếu đến chuỗi này
* trong comStr. Sau đó, nó kiểm tra lệnh hành động với "Exit", như được hiển thị ở đây:
*
* if(comStr.equals("Exit")) System.exit(0);
*
* Nếu lệnh hành động là "Exit", sau đó chương trình sẽ kết thúc bằng cách gọi System.exit(). Phương thức này gây ra
* kết thúc tức thì của một chương trình và truyền đối số của nó như một mã trạng thái cho quá trình gọi, thông thường
* là hệ điều hành. Theo quy ước, mã trạng thái bằng không có nghĩa là kết thúc bình thường. Bất cứ thứ gì khác cho
* thấy rằng chương trình kết thúc một cách không bình thường.
*
* Đối với tất cả các lựa chọn menu khác, lựa chọn được hiển thị.
* Ở điểm này, bạn có thể muốn thử nghiệm một chút với chương trình MenuDemo. Hãy thử thêm một menu khác hoặc thêm các
* mục khác vào một menu hiện có. Quan trọng là bạn hiểu các khái niệm cơ bản về menu trước khi tiếp tục vì chương trình
* này sẽ phát triển trong suốt quá trình của chương này.
* */
