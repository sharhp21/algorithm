package ���α׷��ӽ�;

public class programmers_�űԾ��̵���õ {
    public String solution(String new_id) {
    	// �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
        new_id = new_id.toLowerCase();
       
        // ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
        new_id = new_id.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", "");

        // ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
        while(!new_id.equals(new_id.replace("..", "."))) {
            new_id = new_id.replace("..", ".");
        }
      
        // ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
        if(new_id.length() == 1) {
            if(new_id.charAt(0) == '.') new_id = "";
        }
        else {
            if(new_id.charAt(0) == '.') new_id = new_id.substring(1);
            if(new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);
        }

        // �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
        if(new_id.length() == 0) new_id = "a";

        // ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        
        // ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
        if(new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);
        
        // ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
        if(new_id.length() <= 2) {
            char end = new_id.charAt(new_id.length() - 1);
            while(new_id.length() < 3) {
                new_id += end + "";
            }
        }

        return new_id;
    }
}