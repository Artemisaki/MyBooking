import javax.swing.*;
import java.awt.*;

/**
 * This window is the panel that contains the menu of the admin.
 * It contains buttons for all the actions that an admin can do.
 * Admins can : Accept new users,Send messages,receive messages from other admins,track users
 */
public class AdminWindow extends JPanel {

    private final GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

    private final int PANEL_HEIGHT = (int) (env.getMaximumWindowBounds().getHeight());
    JButton tracking = new JButton("Track other Users");
    JButton approveUser = new JButton("Approve Users");
    JButton showProfile = new JButton("Show Profile");
    JButton showInbox = new JButton("Send messages/Show Inbox");
    JButton logout = new JButton("Log out");

    /**
     * This is the constructor that creates this panel
     * @param admin The admin that is logged in
     * @param listOfAccounts All the accounts of the app
     * @param listOfAccommodations All the accommodations of the app
     * @param listOfReservations All the reservations of the app
     * @param mainFrame The main frame of the app
     */
    public AdminWindow(Admin admin,AccountsCreated listOfAccounts,AccommodationsCreated listOfAccommodations,ReservationsCreated listOfReservations,MainFrame mainFrame){
        this.setSize(1500,800);

        int pxCounter = 80;

        JLabel welcomeMessage = new JLabel();
        welcomeMessage.setText("Hello, " + admin.getFullName());
        String FONT = "Tahoma";
        int TITLE_HEIGHT = 40;
        welcomeMessage.setFont(new Font(FONT,Font.ITALIC+Font.BOLD, TITLE_HEIGHT -10));
        Color CUSTOMIZED_COLOR = Color.decode("#3B5998");
        welcomeMessage.setForeground(CUSTOMIZED_COLOR);
        int PANEL_WIDTH = (int) (env.getMaximumWindowBounds().getWidth() - MainFrame.FRAME_IMAGE_RESOLUTION[0]);
        welcomeMessage.setBounds(0, pxCounter, PANEL_WIDTH, TITLE_HEIGHT);
        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeMessage.setOpaque(false);

        int MARGIN_BTN_FROM_TITLE = 70;
        pxCounter += TITLE_HEIGHT + MARGIN_BTN_FROM_TITLE;

        int BTN_WIDTH = 270;
        int MARGIN_BTN_FROM_EDGES = (PANEL_WIDTH - BTN_WIDTH) / 2;
        int BTN_HEIGHT = 40;
        approveUser.setBounds(MARGIN_BTN_FROM_EDGES, pxCounter, BTN_WIDTH, BTN_HEIGHT);

        int MARGIN_BETWEEN_BTN = 50;
        pxCounter += BTN_HEIGHT + MARGIN_BETWEEN_BTN;

        tracking.setBounds(MARGIN_BTN_FROM_EDGES, pxCounter, BTN_WIDTH, BTN_HEIGHT);

        pxCounter += BTN_HEIGHT + MARGIN_BETWEEN_BTN;

        showProfile.setBounds(MARGIN_BTN_FROM_EDGES, pxCounter, BTN_WIDTH, BTN_HEIGHT);

        pxCounter += BTN_HEIGHT + MARGIN_BETWEEN_BTN;

        showInbox.setBounds(MARGIN_BTN_FROM_EDGES, pxCounter, BTN_WIDTH, BTN_HEIGHT);

        pxCounter += BTN_HEIGHT + MARGIN_BETWEEN_BTN;

        logout.setBounds(MARGIN_BTN_FROM_EDGES, pxCounter, BTN_WIDTH, BTN_HEIGHT);

        approveUser.setBackground(Color.WHITE);
        approveUser.setForeground(CUSTOMIZED_COLOR);
        approveUser.setFont(new Font(FONT,Font.BOLD,16));
        approveUser.setFocusable(false);

        tracking.setBackground(Color.WHITE);
        tracking.setForeground(CUSTOMIZED_COLOR);
        tracking.setFont(new Font(FONT,Font.BOLD,16));
        tracking.setFocusable(false);

        showProfile.setBackground(Color.WHITE);
        showProfile.setForeground(CUSTOMIZED_COLOR);
        showProfile.setFont(new Font(FONT,Font.BOLD,16));
        showProfile.setFocusable(false);

        showInbox.setBackground(Color.WHITE);
        showInbox.setForeground(CUSTOMIZED_COLOR);
        showInbox.setFont(new Font(FONT,Font.BOLD,16));
        showInbox.setFocusable(false);

        logout.setBackground(Color.WHITE);
        logout.setForeground(CUSTOMIZED_COLOR);
        logout.setFont(new Font(FONT,Font.BOLD,16));
        logout.setFocusable(false);

        tracking.addActionListener(e -> {
            mainFrame.remove(this);
            mainFrame.removeInitialImage();
            mainFrame.getContentPane().repaint();
            mainFrame.getContentPane().add(new TrackingWindow(admin,listOfAccounts,listOfAccommodations,listOfReservations,mainFrame));
            mainFrame.getContentPane().repaint();
        });

        showProfile.addActionListener(e-> {
            mainFrame.remove(this);
            mainFrame.removeInitialImage();
            mainFrame.getContentPane().repaint();
            mainFrame.getContentPane().add(new UserProfileWindow(admin,listOfAccounts,listOfAccommodations,listOfReservations, mainFrame));
            mainFrame.getContentPane().repaint();
        });

        approveUser.addActionListener(e -> {
            mainFrame.remove(this);
            mainFrame.removeInitialImage();
            mainFrame.getContentPane().repaint();
            mainFrame.getContentPane().add(new ApproveAccounts(admin,listOfAccounts,listOfAccommodations,listOfReservations,mainFrame));
            mainFrame.getContentPane().repaint();

        });

        showInbox.addActionListener(e -> {
            mainFrame.remove(this);
            mainFrame.removeInitialImage();
            mainFrame.getContentPane().repaint();
            mainFrame.getContentPane().add(new ShowMessagesAdmin(admin,listOfAccounts,listOfAccommodations,listOfReservations,mainFrame));
            mainFrame.getContentPane().repaint();
        });

        logout.addActionListener(e -> {
            mainFrame.remove(this);
            mainFrame.getContentPane().repaint();
            mainFrame.getContentPane().add(new LogInWindow(listOfAccounts,listOfAccommodations,listOfReservations, mainFrame));
            mainFrame.getContentPane().repaint();
        });

        this.add(welcomeMessage);
        this.add(approveUser);
        this.add(tracking);
        this.add(showProfile);
        this.add(showInbox);
        this.add(logout);

        this.setOpaque(false);
        this.setLayout(null);
        this.setVisible(true);
    }
}
